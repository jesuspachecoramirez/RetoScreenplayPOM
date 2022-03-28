package co.com.sofka.task.createaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterface.createaccount.CreateAccountInitialPage.*;

public class BrowseToRegisterInitialPage implements Task {

    private String email;

    public static BrowseToRegisterInitialPage browseToRegisterInitialPage(){
        return new BrowseToRegisterInitialPage();
    }

    public  BrowseToRegisterInitialPage typeAnEmail(String email){
        this.email= email;
        return this;
    }

    public  BrowseToRegisterInitialPage andVerifyEmail(){
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                Scroll.to(HOME_SIGN_IN),
                Click.on(HOME_SIGN_IN),

                Scroll.to(REGISTER_EMAIL),
                Enter.theValue(email).into(REGISTER_EMAIL),

                Scroll.to(HOME_SIGN_IN),
                Click.on(SUBMIT_CREATE)
        );
    }

}
