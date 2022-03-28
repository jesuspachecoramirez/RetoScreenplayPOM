package co.com.sofka.question.signin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterface.signin.SignInPage.FAILED_AUTHENTICATION;

public class FailedSignIn implements Question<String> {
    private static final String FAIL_MESSAGE = "Authentication failed.";

    public static FailedSignIn failedSignIn(){
        return new FailedSignIn();
    }

    public static String getFailMessage(){
        return FAIL_MESSAGE;
    }

    @Override
    public String answeredBy(Actor actor) {
        return FAILED_AUTHENTICATION.resolveFor(actor).getText();
    }
}
