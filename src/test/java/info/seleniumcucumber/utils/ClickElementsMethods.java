package info.seleniumcucumber.utils;

import info.seleniumcucumber.pageAndActionObjects.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickElementsMethods {

    WebDriver driver;
    private WaitHelper waitHelper;

    public ClickElementsMethods(WebDriver driver)
    {
        this.driver = driver;
        waitHelper = new WaitHelper(driver);
    }
    /**
     * Method to click on an element
     *
     * @param element : WebElement : WebElement type
     */
    public void click(WebElement element) throws NoSuchFieldException {
        waitHelper.waitForElementToLoad(element);
        element.click();
    }

    /**
     * Method to forcefully click on an element
     *
     * @param element : WebElement : WebElement type
     */
    public void clickForcefully(WebElement element)  throws NoSuchFieldException {
        waitHelper.waitForElementToLoad(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Method to Double click on an element
     *
     * @param element : WebElement : WebElement type
     */
    public void doubleClick(WebElement element)  throws NoSuchFieldException {
        waitHelper.waitForElementToLoad(element);

        Actions action = new Actions(driver);
        action.moveToElement(element).doubleClick().perform();
    }
}