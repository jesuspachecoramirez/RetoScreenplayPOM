package co.com.sofka.question.createaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterface.createaccount.CreateAccountInitialPage.REGISTER_FORM;

public class UserFormIsDisplayed implements Question<Boolean> {

    public static UserFormIsDisplayed userFormToFillIsDisplayed(){
        return new UserFormIsDisplayed();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return REGISTER_FORM.resolveFor(actor).isDisplayed();
    }
}
