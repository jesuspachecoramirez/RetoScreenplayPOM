package co.com.sofka.userinterface.contactus;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ContactUsPage extends PageObject {

    //For input/access fields
    public static final Target SUBJECT_HEADING = Target
            .the("Subeject heading option")
            .located(By.id("id_contact"));

    public static final Target CONTACT_US_EMAIL = Target
            .the("Contact us email field")
            .located(By.id("email"));

    public static final Target CONTACT_US_MESSAGE = Target
            .the("Contact us message field")
            .located(By.id("message"));

    public static final Target SUBMIT_MESSAGE = Target
            .the("Submit to send the message")
            .located(By.id("submitMessage"));

    //For validations
    public static final Target CONTACT_US_FORM = Target
            .the("Contact us form to fill is displayed")
            .located(By.xpath("//form[@class=\"contact-form-box\"]"));

    public static final Target SENT_MESSAGE = Target
            .the("Successful sent alert message")
            .located(By.xpath("//p[@class=\"alert alert-success\"]"));
}
