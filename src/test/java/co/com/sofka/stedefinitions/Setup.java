package co.com.sofka.stedefinitions;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static co.com.sofka.util.Log4jValues.USER_DIR;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Setup {
    @Managed()
    protected WebDriver webDriver;

    private void setupBrowser(WebDriver webDriver){
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
    }

    private void setupUser(String name, WebDriver webDriver){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(name).can(BrowseTheWeb.with(webDriver));
    }

    protected void actorSetupTheBrowser(String actorName){
        setUpLog4j2();
        setupBrowser(webDriver);
        setupUser(actorName, webDriver);
    }

    private void setUpLog4j2() {
        PropertyConfigurator.configure(USER_DIR.getValue() + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }

}
