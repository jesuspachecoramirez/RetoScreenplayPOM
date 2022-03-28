package co.com.sofka.question.contactus;

import co.com.sofka.question.createaccount.SuccessfulRegister;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterface.contactus.ContactUsPage.SENT_MESSAGE;

public class SuccessfulSentMessage implements Question<String> {
    private static final String DESIRED_SENT_MESSAGE= "Your message has been successfully sent to our team.";

    public static SuccessfulSentMessage successfulSentMessage(){
        return new SuccessfulSentMessage();
    }
    public static String getSuccessSentMessage(){
        return DESIRED_SENT_MESSAGE;
    }


    @Override
    public String answeredBy(Actor actor) {
        return SENT_MESSAGE.resolveFor(actor).getText();
    }
}
