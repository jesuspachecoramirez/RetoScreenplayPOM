package co.com.sofka.task.signin;


import co.com.sofka.models.createaccount.CreateAccountModel;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.nio.charset.StandardCharsets;

public class ExistingAccount implements Task {

    private CreateAccountModel userData;

    public static ExistingAccount existingAccount(){
        return new ExistingAccount();
    }
    public ExistingAccount setUserData(CreateAccountModel userData) {
        this.userData = userData;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("?controller=authentication")
                        .with(
                                requestSpecification -> requestSpecification
                                        .contentType(ContentType.URLENC.withCharset(StandardCharsets.UTF_8))
                                        .body(bodyBase(
                                                userData.getFirstName(),
                                                userData.getLastName(),
                                                userData.getEmail(),
                                                userData.getPassword(),
                                                userData.getAddress(),
                                                userData.getCity(),
                                                userData.getState(),
                                                userData.getPostalCode(),
                                                userData.getMobilePhone()
                                        ))
                        )
        );
    }

    private String bodyBase(
            String firstName,
            String lastName,
            String email,
            String password,
            String address,
            String city,
            int state,
            String postalCode,
            String mobilePhone
    ) {

        return "customer_firstname=" + firstName + "&" +
                "customer_lastname=" + lastName + "&" +
                "email=" + email + "&" +
                "passwd=" + password + "&" +
                "days=&" +
                "months=&" +
                "years=&" +
                "firstname=" + firstName + "&" +
                "lastname=" + lastName + "&" +
                "company=&" +
                "address1=" + address + "&" +
                "address2=&" +
                "city=" + city + "&" +
                "id_state=" + state + "&" +
                "postcode=" + postalCode + "&" +
                "id_country=21&" +
                "other=&" +
                "phone=&" +
                "phone_mobile=" + mobilePhone + "&" +
                "alias=My+address&" +
                "dni=&email_create=1&" +
                "is_new_customer=1&" +
                "back=my-account&" +
                "submitAccount=";
    }
}
