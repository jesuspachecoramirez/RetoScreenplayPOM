package co.com.sofka.task.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterface.contactus.ContactUsHomePage.CONTACT_US_OPTION;

public class BrowseToContacUs implements Task {

    public static BrowseToContacUs browseToContactUs(){
        return new BrowseToContacUs();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                Scroll.to(CONTACT_US_OPTION),
                Click.on(CONTACT_US_OPTION)
        );
    }

}
