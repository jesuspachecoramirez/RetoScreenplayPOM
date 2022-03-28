package co.com.sofka.runners.contactus;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/contactus/contactus.feature"},
        glue = {"co.com.sofka.stedefinitions.contactus"}
)

public class ContactUsTest {
}
