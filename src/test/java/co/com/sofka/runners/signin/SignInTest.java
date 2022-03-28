package co.com.sofka.runners.signin;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/signin/signin.feature"},
        glue = {"co.com.sofka.stedefinitions.signin"}
)

public class SignInTest {
}
