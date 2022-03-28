package co.com.sofka.runners.createaccount;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/createaccount/createaccount.feature"},
        glue = {"co.com.sofka.stedefinitions.createaccount"}
)

public class CreateAccountTest {
}
