package co.com.sofka.question.createaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.List;

import static co.com.sofka.userinterface.createaccount.CreateAccountFormPage.USER_NAME_VALIDATOR;
import static co.com.sofka.userinterface.createaccount.CreateAccountFormPage.WELCOME_MESSAGE;

public class SuccessfulRegister implements Question<List<String>> {
    private static final String DESIRED_WELCOME_MESSAGE = "Welcome to your account. Here you can manage all of your personal information and orders.";

    public static SuccessfulRegister successfulRegister(){
        return new SuccessfulRegister();
    }

    public static String getDesiredWelcomeMessage(){
        return DESIRED_WELCOME_MESSAGE;
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        List<String> desiredResponse = new ArrayList<>();
        desiredResponse.add(USER_NAME_VALIDATOR.resolveFor(actor).getText());
        desiredResponse.add(WELCOME_MESSAGE.resolveFor(actor).getText());
        return desiredResponse;
    }
}
