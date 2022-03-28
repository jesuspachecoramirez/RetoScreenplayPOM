package co.com.sofka.stedefinitions.createaccount;

import co.com.sofka.models.createaccount.CreateAccountModel;
import co.com.sofka.stedefinitions.Setup.Setup;
import co.com.sofka.util.State;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static co.com.sofka.question.createaccount.SuccessfulRegister.getDesiredWelcomeMessage;
import static co.com.sofka.question.createaccount.SuccessfulRegister.successfulRegister;
import static co.com.sofka.question.createaccount.UserFormIsDisplayed.userFormToFillIsDisplayed;
import static co.com.sofka.task.createaccount.BrowseToRegisterInitialPage.browseToRegisterInitialPage;
import static co.com.sofka.task.createaccount.FillRequiredRegisterFields.fillRequiredRegisterFields;
import static co.com.sofka.task.homepage.OpenHomePage.openHomePage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.*;


public class CreateAccountStepDefinition extends Setup {

    private static final Logger LOGGER = Logger.getLogger(CreateAccountStepDefinition.class);
    private static final String ACTOR_NAME = "User";

    private final CreateAccountModel newAccount = new CreateAccountModel();
    private final Faker faker = new Faker();


    @Given("el cliente se encuentra en la pagina Authentication")
    public void elClienteSeEncuentraEnLaPaginaAuthentication() {
        actorSetupTheBrowser(ACTOR_NAME);
        try {
            theActorInTheSpotlight()
                    .wasAbleTo(
                            openHomePage()
                    );
        } catch (Exception exception) {
            LOGGER.error("Error accediendo al home de la pagina", exception);
        }
    }

    @When("el cliente ingresa en la seccion de creacion de cuenta y digita un email valido")
    public void elClienteIngresaEnLaSeccionDeCreacionDeCuentaYDigitaUnEmailValido() {
        newAccount.setEmail(faker.internet().safeEmailAddress());
        try {
            theActorInTheSpotlight()
                    .attemptsTo(
                            browseToRegisterInitialPage()
                                    .typeAnEmail(newAccount.getEmail())
                                    .andVerifyEmail()
                    );
        } catch (Exception exception) {
            LOGGER.error("Error validando email", exception);
        }
    }

    @Then("la pagina redirecciona al cliente correctamente para que ingrese la informacion restante")
    public void laPaginaRedireccionaAlClienteCorrectamenteParaQueIngreseLaInformacionRestante() {
        theActorInTheSpotlight()
                .should(
                        seeThat("exist a form to fill user information",
                                userFormToFillIsDisplayed(),
                                is(true)
                        )
                );
    }

    @Given("El correo del cliente es valido y se encuentra en la seccion donde ingresa la informacion restante")
    public void elCorreoDelClienteEsValidoYSeEncuentraEnLaSeccionDondeIngresaLaInformacionRestante() {
        newAccount.setEmail(faker.internet().emailAddress());
        try {
            theActorInTheSpotlight()
                    .attemptsTo(
                            browseToRegisterInitialPage()
                                    .typeAnEmail(newAccount.getEmail())
                                    .andVerifyEmail()
                    );
        } catch (Exception exception) {
            LOGGER.error("Error validando email", exception);
        }
    }

    @When("el cliente ingresa su infomacion en los campos obligatorios y presiona register")
    public void elClienteIngresaSuInfomacionEnLosCamposObligatoriosYPresionaRegister() {
        newAccount.setFirstName(faker.name().firstName());
        newAccount.setLastName(faker.name().lastName());
        newAccount.setPassword(faker.internet().password(5,15,true));
        newAccount.setAddress(faker.address().streetAddress());
        newAccount.setCity(faker.address().city());
        newAccount.setState(faker.number().numberBetween(1, State.values().length));
        newAccount.setPostalCode(faker.number().digits(5));
        newAccount.setMobilePhone(faker.phoneNumber().cellPhone());
        theActorInTheSpotlight()
                .attemptsTo(
                        fillRequiredRegisterFields()
                                .typingAFirstName(newAccount.getFirstName())
                                .typingALastName(newAccount.getLastName())
                                .typingAPassword(newAccount.getPassword())
                                .typingACity(newAccount.getCity())
                                .typingAnAddress(newAccount.getAddress())
                                .selectedAState(newAccount.getState())
                                .typingAPostalCode(newAccount.getPostalCode())
                                .typingAMobilePhone(newAccount.getMobilePhone())
                                .andClickingRegister()
                );
    }

    @Then("recibe un mensaje de que su registro fue exitoso")
    public void recibeUnMensajeDeQueSuRegistroFueExitoso() {
        theActorInTheSpotlight()
                .should(
                        seeThat("actual page shows the user name and a welcome message",
                                successfulRegister(),
                                hasItems((newAccount.getFirstName() + " " + newAccount.getLastName()),
                                        getDesiredWelcomeMessage()
                                )
                        )
                );
    }




}
