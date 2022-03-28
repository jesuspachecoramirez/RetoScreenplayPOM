package co.com.sofka.stedefinitions.signin;

import co.com.sofka.models.createaccount.CreateAccountModel;
import co.com.sofka.models.signin.SignInModel;
import co.com.sofka.stedefinitions.Setup.Setup;
import co.com.sofka.util.State;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.log4j.Logger;

import static co.com.sofka.question.signin.FailedSignIn.failedSignIn;
import static co.com.sofka.question.signin.FailedSignIn.getFailMessage;
import static co.com.sofka.question.signin.SuccessfulSignIn.getDesiredWelcomeMessage;
import static co.com.sofka.question.signin.SuccessfulSignIn.successfulSignIn;
import static co.com.sofka.task.homepage.OpenHomePage.openHomePage;
import static co.com.sofka.task.signin.BrowseToSignInPage.browseToSignInPage;
import static co.com.sofka.task.signin.ExistingAccount.existingAccount;
import static co.com.sofka.task.signin.FillLoginFields.fillLoginFields;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;

public class SignInStepDefinition extends Setup {
    private static final Logger LOGGER = Logger.getLogger(SignInStepDefinition.class);
    private static final String ACTOR_NAME = "User";

    private final CreateAccountModel account = new CreateAccountModel();
    private final SignInModel userAccount = new SignInModel();
    private final Faker faker = new Faker();

    @Given("el cliente ya tiene una cuenta creada")
    public void elClienteYaTieneUnaCuentaCreada() {
        actorSetupTheBrowser(ACTOR_NAME);

        account.setFirstName(faker.name().firstName());
        account.setLastName(faker.name().lastName());
        account.setEmail(faker.internet().emailAddress());
        account.setPassword(faker.internet().password(5, 15, true));
        account.setAddress(faker.address().streetAddress());
        account.setCity(faker.address().city());
        account.setState(faker.number().numberBetween(1, State.values().length));
        account.setPostalCode(faker.number().digits(5));
        account.setMobilePhone(faker.phoneNumber().cellPhone());

        try {
            theActorInTheSpotlight().can(CallAnApi.at("http://automationpractice.com/index.php"));
            theActorInTheSpotlight().attemptsTo(
                    existingAccount()
                            .setUserData(account)
            );
        } catch (Exception exception) {
            LOGGER.error("Error verificando cuenta existente", exception);
        }
    }

    @And("accede al home de la pagina y va a la seccion de log in")
    public void accedeAlHomeDeLaPaginaYVaALaSeccionDeLogIn() {
        try {
            theActorInTheSpotlight()
                    .wasAbleTo(
                            openHomePage(),
                            browseToSignInPage()
                    );
        } catch (Exception exception) {
            LOGGER.error("Error accediendo a la pagina registro");
        }
    }

    @When("el cliente digita su email y su contrasena correctamente y presiona signin")
    public void elClienteDigitaSuEmailYSuContrasenaCorrectamenteYPresionaSignin() {
        userAccount.setEmail(account.getEmail());
        userAccount.setPassword(account.getPassword());
        try {

            theActorInTheSpotlight()
                    .attemptsTo(
                            fillLoginFields()
                                    .typingAnUserEmail(userAccount.getEmail())
                                    .typingAnUserPassword(userAccount.getPassword())
                                    .andClickingSignIn()
                    );
        } catch (Exception exception) {
            LOGGER.error("Error rellenando los campos de login", exception);
        }
    }

    @Then("el cliente accede correctamente a su cuenta")
    public void elClienteAccedeCorrectamenteASuCuenta() {
        theActorInTheSpotlight()
                .should(
                        seeThat("actual page shows the user name and a welcome message",
                                successfulSignIn(),
                                hasItems((account.getFirstName() + " " + account.getLastName()),
                                        getDesiredWelcomeMessage()
                                )
                        )
                );
    }

    @When("el cliente digita su email y su contrasena no es correcta al presionar signin")
    public void elClienteDigitaSuEmailYSuContrasenaNoEsCorrectaAlPresionarSignin() {
        userAccount.setEmail(account.getEmail());
        userAccount.setPassword(faker.internet().password());

        try {
            theActorInTheSpotlight()
                    .attemptsTo(
                            fillLoginFields()
                                    .typingAnUserEmail(userAccount.getEmail())
                                    .typingAnUserPassword(userAccount.getPassword())
                                    .andClickingSignIn()
                    );
        } catch (Exception exception) {
            LOGGER.error("Error rellenando los campos de login", exception);
        }
    }

    @Then("el cliente recibe un mensaje de error en la autenticacion")
    public void elClienteRecibeUnMensajeDeErrorEnLaAutenticacion() {
        theActorInTheSpotlight()
                .should(
                        seeThat("there is an error message about failed authentication",
                                failedSignIn(),
                                is(getFailMessage())
                        )
                );
    }




}
