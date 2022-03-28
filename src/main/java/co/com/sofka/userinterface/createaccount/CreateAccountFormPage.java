package co.com.sofka.userinterface.createaccount;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CreateAccountFormPage {

    //For input/access fields
    public static final Target FIRST_NAME = Target
            .the("First name")
            .located(By.id("customer_firstname"));

    public static final Target LAST_NAME = Target
            .the("Last name")
            .located(By.id("customer_lastname"));

    public static final Target REGISTER_PASSWORD = Target
            .the("Password")
            .located(By.id("passwd"));

    public static final Target ADDRESS = Target
            .the("Address")
            .located(By.id("address1"));

    public static final Target CITY = Target
            .the("City")
            .located(By.id("city"));

    public static final Target STATE = Target
            .the("State")
            .located(By.id("id_state"));

    public static final Target POSTAL_CODE = Target
            .the("Zip/Postal code")
            .located(By.id("postcode"));

    public static final Target MOBILE_PHONE = Target
            .the("Mobile phone")
            .located(By.id("phone_mobile"));

    public static final Target SUBMIT_REGISTER = Target
            .the("Submit register")
            .located(By.id("submitAccount"));

    //For validations
    public static final Target USER_NAME_VALIDATOR = Target
            .the("User name in screen")
            .located(By.xpath("//a[@title=\"View my customer account\"]"));

    public static final Target WELCOME_MESSAGE = Target
            .the("Welcome message")
            .located(By.xpath("//p[@class=\"info-account\"]"));
}
