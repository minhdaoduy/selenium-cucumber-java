//package info.seleniumcucumber.steps;
//
//import info.seleniumcucumber.pageAndActionObjects.AbstractPage;
////import io.cucumber.core.api.Scenario;
//import info.seleniumcucumber.utils.WebDriverFactory;
//import io.cucumber.java.*;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.slf4j.Marker;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import org.openqa.selenium.WebDriver;
//
//public class Hooks extends AbstractPage {
//    private final Logger log = LoggerFactory.getLogger(Hooks.class);
//    private ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();
////    @Before
////    public void beforeScenario(Scenario scenario) throws IOException {
////        endOfTest(scenario);
////        if (getDriver() == null)
////            getDriver();
////    }
//    @BeforeStep
//    public void beforeStep() {
//        WebDriverFactory webDriverFactory = new WebDriverFactory();
//        webDriverFactory.setDriver();
//        webdriver.set(webDriverFactory.getDriver());
//
//    }
//
//    @AfterStep
//    public void afterStep() {
//        webdriver.get().close();
//    }
//
//    @After
//    public void afterScenario(Scenario scenario) throws IOException {
//        endOfTest(scenario);
////        setDriverThreadLocal();
//    }
//
//    public void endOfTest(Scenario scenario) throws IOException {
//        if (scenario.getStatus() != null && scenario.isFailed()) {
//            byte[] screenshotBytes = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
////            scenario.embed(screenshotBytes, "image/png");
//            scenario.attach(screenshotBytes, "image/png", "screenshot.png");
////            scenario.embed(screenshotBytes, "image/png", "screenshot.png");
//        }
//        String resultLog = "=================Test " + scenario.getName() + ": " + scenario.getStatus().toString() + "=================";
//        String equalCharacters = "====================================================================================================================================================";
//        equalCharacters = equalCharacters.substring(0, resultLog.length());
//        log.info(equalCharacters);
//        log.info(resultLog);
//        log.info(equalCharacters);
//
////        getDriver().quit();
//    }
//}
package info.seleniumcucumber.steps;

import info.seleniumcucumber.cucumber.TestContext;
import info.seleniumcucumber.pageAndActionObjects.AbstractPage;
//import io.cucumber.core.api.Scenario;
import info.seleniumcucumber.utils.WebDriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private final Logger log = LoggerFactory.getLogger(Hooks.class);
//    private ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();
    private ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();
    TestContext testContext;
    WebDriver driver;

    public Hooks(TestContext context) {
//        testContext = context;
//        driver = testContext.getWebDriverManager().getDriver();
//        webdriver.set(driver);
    }

    @Before
    public void beforeScenario(Scenario scenario) throws IOException {
        testContext = new TestContext();
        driver = testContext.getWebDriverManager().getDriver();
        webdriver.set(driver);
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        endOfTest(scenario);
//        setDriverThreadLocal();
    }

    public void endOfTest(Scenario scenario) throws IOException {
        if (scenario.getStatus() != null && scenario.isFailed()) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
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

        webdriver.get().close();
    }
}
