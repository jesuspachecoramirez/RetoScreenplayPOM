package co.com.sofka.stedefinitions.contactus;

import co.com.sofka.models.contactus.ContactUsModel;
import co.com.sofka.stedefinitions.Setup.Setup;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
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

    @When("el cliente se encuentra en el home de la pagina")
    public void elClienteSeEncuentraEnElHomeDeLaPagina() {
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

    @Then("valida una opcion de Contact Us e ingresa")
    public void validaUnaOpcionDeContactUsEIngresa() {
        try {
            theActorInTheSpotlight()
                    .attemptsTo(
                            browseToContactUs()
                    );
        } catch (Exception exception) {
            LOGGER.error("Error accediendo a la pagina de Contact Us", exception);
        }
    }

    @And("aparece un formulario que debe llenar")
    public void apareceUnFormularioQueDebeLlenar() {
        theActorInTheSpotlight()
                .should(
                        seeThat("exist a form to send a message",
                                contactUsFormIsDisplayed(),
                                equalTo(true)
                        )
                );
    }

    @Given("el cliente se encuentra en la pagina de Contact us")
    public void elClienteSeEncuentraEnLaPaginaDeContactUs() {
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

    @When("llena la informacion de los campos obligatorios y presiona en enviar")
    public void llenaLaInformacionDeLosCamposObligatoriosYPresionaEnEnviar() {
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
