package co.com.sofka.userinterface.contactus;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ContactUsHomePage extends PageObject {

    public static final Target CONTACT_US_OPTION = Target
            .the("Contact Us option in home")
            .located(By.linkText("Contact us"));
}
