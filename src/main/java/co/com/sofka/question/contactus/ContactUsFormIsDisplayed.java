package co.com.sofka.question.contactus;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterface.contactus.ContactUsPage.CONTACT_US_FORM;


public class ContactUsFormIsDisplayed implements Question<Boolean> {

    public static ContactUsFormIsDisplayed contactUsFormIsDisplayed(){
        return new ContactUsFormIsDisplayed();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return CONTACT_US_FORM.resolveFor(actor).isDisplayed();
    }
}
