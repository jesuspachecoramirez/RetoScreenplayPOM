package co.com.sofka.userinterface.createaccount;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateAccountInitialPage extends PageObject {

    //For input/access fields
    public static final Target HOME_SIGN_IN = Target
            .the("Sign in option on home page")
            .located(By.linkText("Sign in"));

    public static final Target REGISTER_EMAIL = Target
            .the("Register email field")
            .located(By.id("email_create"));

    public static final Target SUBMIT_CREATE = Target
            .the("Submit create an account")
            .located(By.id("SubmitCreate"));

    //For validations
    public static final Target REGISTER_FORM = Target
            .the("Register form")
            .located(By.id("account-creation_form"));
}
