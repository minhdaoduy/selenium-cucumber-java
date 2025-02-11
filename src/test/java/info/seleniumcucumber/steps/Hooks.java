package info.seleniumcucumber.steps;

import info.seleniumcucumber.pageAndActionObjects.AbstractPage;
//import io.cucumber.core.api.Scenario;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Hooks extends AbstractPage {
//public class Hooks {
    private final Logger log = LoggerFactory.getLogger(Hooks.class);

//    @Before
    @BeforeMethod
    public void beforeScenario() {
        setUp();
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        endOfTest(scenario);
    }

    public void endOfTest(Scenario scenario) throws IOException {
        if (scenario.getStatus() != null && scenario.isFailed()) {
            byte[] screenshotBytes = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.embed(screenshotBytes, "image/png");
            scenario.attach(screenshotBytes, "image/png", "screenshot.png");
//            scenario.embed(screenshotBytes, "image/png", "screenshot.png");
        }
        String resultLog = "=================Test " + scenario.getName() + ": " + scenario.getStatus().toString() + "=================";
        String equalCharacters = "====================================================================================================================================================";
        equalCharacters = equalCharacters.substring(0, resultLog.length());
        log.info(equalCharacters);
        log.info(resultLog);
        log.info(equalCharacters);
        getDriver().close();
        getDriver().quit();
    }
}
