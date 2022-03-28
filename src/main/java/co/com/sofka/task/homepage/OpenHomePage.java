package co.com.sofka.task.homepage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import static co.com.sofka.userinterface.homepage.HomePage.homePage;

public class OpenHomePage implements Task {

    public static OpenHomePage openHomePage() {
        return new OpenHomePage();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                Open.browserOn(homePage())
        );
    }

}
