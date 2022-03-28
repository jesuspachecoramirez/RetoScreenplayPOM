package co.com.sofka.task.contactus;

import co.com.sofka.task.createaccount.FillRequiredRegisterFields;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static co.com.sofka.userinterface.contactus.ContactUsPage.*;
import static co.com.sofka.userinterface.createaccount.CreateAccountFormPage.*;
import static co.com.sofka.userinterface.createaccount.CreateAccountFormPage.SUBMIT_REGISTER;

public class FillRequiredContactUsFields implements Task {

    private int subjectHeading;
    private String email;
    private String message;


    public static FillRequiredContactUsFields fillRequiredContactUsFields(){
        return new FillRequiredContactUsFields();
    }

    public FillRequiredContactUsFields selectingASubjectHeading(int subjectHeading){
        this.subjectHeading= subjectHeading;
        return this;
    }

    public FillRequiredContactUsFields typingAnEmail(String email){
        this.email= email;
        return this;
    }

    public FillRequiredContactUsFields typingAMessage (String message){
        this.message= message;
        return this;
    }

    public FillRequiredContactUsFields andClickingSend (){
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Scroll.to(SUBJECT_HEADING),
                SelectFromOptions.byValue(String.valueOf(subjectHeading)).from(SUBJECT_HEADING),

                Scroll.to(CONTACT_US_EMAIL),
                Enter.theValue(email).into(CONTACT_US_EMAIL),

                Scroll.to(CONTACT_US_MESSAGE),
                Enter.theValue(message).into(CONTACT_US_MESSAGE),

                Scroll.to(SUBMIT_MESSAGE),
                Click.on(SUBMIT_MESSAGE)
        );
    }
}
