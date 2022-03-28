package co.com.sofka.task.signin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static co.com.sofka.userinterface.signin.SignInPage.*;

public class FillLoginFields implements Task {

    private String email;
    private String password;

    public static FillLoginFields fillLoginFields(){
        return new FillLoginFields();
    }

    public FillLoginFields typingAnUserEmail (String email){
        this.email= email;
        return this;
    }

    public FillLoginFields typingAnUserPassword(String password){
        this.password= password;
        return this;
    }

    public FillLoginFields andClickingSignIn (){
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(SIGN_IN_EMAIL),
                Enter.theValue(email).into(SIGN_IN_EMAIL),

                Scroll.to(SIGN_IN_PASSWORD),
                Enter.theValue(password).into(SIGN_IN_PASSWORD),

                Scroll.to(SUBMIT_LOGIN),
                Click.on(SUBMIT_LOGIN)
        );
    }
}
