package info.seleniumcucumber.utils;

import com.paulhammant.ngwebdriver.NgWebDriver;
import info.seleniumcucumber.constants.Constants;
import info.seleniumcucumber.utils.expectedConditions.ClickabilityOfElement;
import info.seleniumcucumber.utils.expectedConditions.InvisibilityOfElement;
import info.seleniumcucumber.utils.expectedConditions.VisibilityOfElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.NoSuchElementException;

public class WaitHelper {

    private final Logger logger = LoggerFactory.getLogger(WaitHelper.class);

    private WebDriver driver;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForAngular() {
        waitUntilAngularReady();
    }

    public void waitForElementToLoad(WebElement element) throws NoSuchFieldException {
//        waitForAngular();
        waitForElementVisible(element);
        waitForElementClickable(element);
    }

    /**
     * Wait for Angular loads using Ng Driver
     */
    private void ngDriverWait() {
        final NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
        try {
            ngWebDriver.waitForAngularRequestsToFinish();
        } catch (ScriptTimeoutException exception) {
            logger.info("Problems waiting for Angular to load with NgWeb Driver");
            logger.debug("Problems waiting for Angular to load with NgWeb Driver");
        }
    }

    /**
     * wait for element visible by element
     */
    private void waitForElementVisible(WebElement element) {
        try {
            waitLong().until(new VisibilityOfElement(element));
        } catch (Exception ignored) {
        }
    }

    /**
     * wait for element Invisible by locator
     */
    private void waitForElementInVisible(WebElement element) {
        try {
            new InvisibilityOfElement(element);
        } catch (Exception ignored) {
        }
    }

    /**
     * wait for element clickable by element
     */
    private void waitForElementClickable(WebElement element) throws NoSuchFieldException {
        try {
            waitLong().until(new ClickabilityOfElement(element));
        } catch (Exception t) {
            throw new NoSuchFieldException("could not interact with the element " + element);
        }
    }

    public Wait<WebDriver> waitLong() {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(Constants.timeoutLong))
                .pollingEvery(Duration.ofMillis(Constants.pollingLong))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    public Wait<WebDriver> waitShort() {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(Constants.timeoutShort))
                .pollingEvery(Duration.ofMillis(Constants.pollingShort))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
    }

    private void waitUntilAngularReady() {

        final Boolean angularUnDefined = (Boolean) ((JavascriptExecutor) driver).executeScript("return window.angular === undefined");

        if (!angularUnDefined) {
            Boolean angularInjectorUnDefined = (Boolean) ((JavascriptExecutor) driver).executeScript("return angular.element(document).injector() === undefined");
            if (!angularInjectorUnDefined) {
                waitForAngularLoad();
                waitUntilJSReady();
                waitForJQueryLoad();
                ngDriverWait();
            }
        }
    }

    private void waitForAngularLoad() {

        final String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

        final ExpectedCondition<Boolean> angularLoad = driver -> Boolean.valueOf(
                ((JavascriptExecutor) driver).executeScript(angularReadyScript).toString());

        boolean angularReady = Boolean
                .parseBoolean(((JavascriptExecutor) driver).executeScript(angularReadyScript).toString());

        if (!angularReady) {
            waitLong().until(angularLoad);
        }
    }

    private void waitUntilJSReady() {
        final ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState")
                .toString()
                .equals("complete");

        boolean jsReady = ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .toString().equals("complete");

        if (!jsReady) {
            waitLong().until(jsLoad);
        }
    }

    private void waitForJQueryLoad() {
        final ExpectedCondition<Boolean> jQueryLoad = driver -> (
                (Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);

        boolean jqueryReady = (Boolean) ((JavascriptExecutor) driver).executeScript("return jQuery.active==0");

        if (!jqueryReady) {
            waitLong().until(jQueryLoad);
        }
    }
}
