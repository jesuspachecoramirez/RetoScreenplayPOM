package co.com.sofka.userinterface.signin;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SignInPage extends PageObject {

    //For input/access fields

    public static final Target SIGN_IN_EMAIL = Target
            .the("Login email field")
            .located(By.id("email"));

    public static final Target SIGN_IN_PASSWORD = Target
            .the("Password field")
            .located(By.id("passwd"));

    public static final Target SUBMIT_LOGIN = Target
            .the("Sign in button")
            .located(By.id("SubmitLogin"));

    //For validations
    public static final Target USER_NAME_VALIDATOR = Target
            .the("User name in screen")
            .located(By.xpath("//a[@title=\"View my customer account\"]"));

    public static final Target WELCOME_MESSAGE = Target
            .the("Welcome message")
            .located(By.xpath("//p[@class=\"info-account\"]"));

    public static final Target FAILED_AUTHENTICATION= Target
            .the("Error for incorrect credentials")
            .located(By.xpath("//div[@id=\"center_column\"]/div[1]/ol/li"));
}
