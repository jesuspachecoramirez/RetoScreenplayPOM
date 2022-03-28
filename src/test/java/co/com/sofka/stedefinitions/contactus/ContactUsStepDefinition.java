package co.com.sofka.stedefinitions.contactus;

import co.com.sofka.models.contactus.ContactUsModel;
import co.com.sofka.stedefinitions.Setup;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static co.com.sofka.question.contactus.ContactUsFormIsDisplayed.contactUsFormIsDisplayed;
import static co.com.sofka.question.contactus.SuccessfulSentMessage.getSuccessSentMessage;
import static co.com.sofka.question.contactus.SuccessfulSentMessage.successfulSentMessage;
import static co.com.sofka.task.contactus.BrowseToContacUs.browseToContactUs;
import static co.com.sofka.task.contactus.FillRequiredContactUsFields.fillRequiredContactUsFields;
import static co.com.sofka.task.homepage.OpenHomePage.openHomePage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContactUsStepDefinition extends Setup {

    private static final Logger LOGGER = Logger.getLogger(ContactUsStepDefinition.class);
    private static final String ACTOR_NAME = "User";

    private final ContactUsModel user = new ContactUsModel();
    private final Faker faker = new Faker();

    @When("el usuario visitante de la pagina se encuentra en el home")
    public void elUsuarioVisitanteDeLaPaginaSeEncuentraEnElHome() {
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

    @Then("existe una opcion de Contact Us y accede")
    public void existeUnaOpcionDeContactUsYAccede() {
        try {
            theActorInTheSpotlight()
                    .attemptsTo(
                            browseToContactUs()
                    );
        } catch (Exception exception) {
            LOGGER.error("Error accediendo a la pagina de Contact Us", exception);
        }
    }

    @Then("aparece un formulaio para llenar")
    public void apareceUnFormulaioParaLlenar() {
        theActorInTheSpotlight()
                .should(
                        seeThat("exist a form to send a message",
                                contactUsFormIsDisplayed(),
                                equalTo(true)
                        )
                );
    }

    @Given("el usuario visitante se encuentra en la pagina de Contact us")
    public void elUsuarioVisitanteSeEncuentraEnLaPaginaDeContactUs() {
        actorSetupTheBrowser(ACTOR_NAME);
        try {
            theActorInTheSpotlight()
                    .attemptsTo(
                            openHomePage(),
                            browseToContactUs()
                    );
        } catch (Exception exception) {
            LOGGER.error("Error accediendo a la pagina de Contact Us", exception);
        }
    }

    @When("llena la informacion de los campos obligatorios y valida su accion")
    public void llenaLaInformacionDeLosCamposObligatoriosYValidaSuAccion() {
        user.setSubjectHeading(faker.number().numberBetween(1,2));
        user.setEmail(faker.internet().emailAddress());
        user.setMessage(faker.lorem().paragraph());
        try {
            theActorInTheSpotlight()
                    .attemptsTo(
                            fillRequiredContactUsFields()
                                    .selectingASubjectHeading(user.getSubjectHeading())
                                    .typingAnEmail(user.getEmail())
                                    .typingAMessage(user.getMessage())
                                    .andClickingSend()
                    );
        } catch (Exception exception) {
            LOGGER.error("Error rellenando los campos de login", exception);
        }
    }

    @Then("aparece un mensaje de envio exitoso")
    public void apareceUnMensajeDeEnvioExitoso() {
        theActorInTheSpotlight()
                .should(
                        seeThat("the sent message was successful",
                                successfulSentMessage(),
                                equalTo(getSuccessSentMessage()))
                );
    }
}
