package co.com.sofka.task.createaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static co.com.sofka.userinterface.createaccount.CreateAccountFormPage.*;
import static co.com.sofka.userinterface.createaccount.CreateAccountFormPage.REGISTER_PASSWORD;

public class FillRequiredRegisterFields implements Task {

    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String city;
    private int state;
    private String postalCode;
    private String mobilePhone;

    public static FillRequiredRegisterFields fillRequiredRegisterFields(){
        return new FillRequiredRegisterFields();
    }

    public FillRequiredRegisterFields typingAFirstName (String firstName){
        this.firstName= firstName;
        return this;
    }

    public FillRequiredRegisterFields typingALastName (String lastName){
        this.lastName= lastName;
        return this;
    }
    public FillRequiredRegisterFields typingAPassword(String password){
        this.password= password;
        return this;
    }
    public FillRequiredRegisterFields typingAnAddress (String address){
        this.address= address;
        return this;
    }
    public FillRequiredRegisterFields typingACity (String city){
        this.city= city;
        return this;
    }
    public FillRequiredRegisterFields selectedAState(int state){
        this.state= state;
        return this;
    }
    public FillRequiredRegisterFields typingAPostalCode(String postalCode){
        this.postalCode= postalCode;
        return this;
    }
    public FillRequiredRegisterFields typingAMobilePhone (String mobilePhone){
        this.mobilePhone= mobilePhone;
        return this;
    }

    public FillRequiredRegisterFields andClickingRegister (){
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    Scroll.to(FIRST_NAME),
                    Enter.theValue(firstName).into(FIRST_NAME),

                    Scroll.to(LAST_NAME),
                    Enter.theValue(lastName).into(LAST_NAME),

                    Scroll.to(REGISTER_PASSWORD),
                    Enter.theValue(password).into(REGISTER_PASSWORD),

                    Scroll.to(ADDRESS),
                    Enter.theValue(address).into(ADDRESS),

                    Scroll.to(CITY),
                    Enter.theValue(city).into(CITY),

                    Scroll.to(STATE),
                    SelectFromOptions.byValue(String.valueOf(state)).from(STATE),

                    Scroll.to(POSTAL_CODE),
                    Enter.theValue(postalCode).into(POSTAL_CODE),

                    Scroll.to(MOBILE_PHONE),
                    Enter.theValue(mobilePhone).into(MOBILE_PHONE),

                    Scroll.to(SUBMIT_REGISTER),
                    Click.on(SUBMIT_REGISTER)
            );
    }
}
