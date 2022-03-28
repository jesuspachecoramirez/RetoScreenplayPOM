package co.com.sofka.task.signin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterface.createaccount.CreateAccountInitialPage.*;

public class BrowseToSignInPage implements Task {

    public static BrowseToSignInPage browseToSignInPage(){
        return new BrowseToSignInPage();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                Scroll.to(HOME_SIGN_IN),
                Click.on(HOME_SIGN_IN)
        );
    }
}
