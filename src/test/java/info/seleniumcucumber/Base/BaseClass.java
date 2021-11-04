package info.seleniumcucumber.Base;

import info.seleniumcucumber.pageAndActionObjects.APMyAccountPage2;
import info.seleniumcucumber.utils.*;
import info.seleniumcucumber.utils.dataproviders.ConfigFileReader;
import info.seleniumcucumber.utils.dataproviders.ExcelDataReader;
import info.seleniumcucumber.utils.dataproviders.JsonDataReader;
import org.apache.commons.io.FileUtils;
//import org.apache.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class BaseClass {

	public static WebDriver driver;
	private NavigateMethods navigationObj = new NavigateMethods(driver);
	private AssertionMethods assertionObj = new AssertionMethods(driver);
	private ClickElementsMethods clickObj = new ClickElementsMethods(driver);
	private InputMethods inputObj = new InputMethods(driver);
	private JavascriptHandlingMethods javascriptObj = new JavascriptHandlingMethods();
	private ScreenShotMethods screenshotObj = new ScreenShotMethods();
	private ConfigFileReader configFileReader = new ConfigFileReader();
	private ExcelDataReader excelDataReader = new ExcelDataReader();
	private JsonDataReader jsonDataReader = new JsonDataReader();
	private ValidateEmail validateEmail = new ValidateEmail();
	
	public BaseClass(WebDriver driver)
	{
		this.driver = driver;
	}

	public NavigateMethods getNavigateMethods() {
		return (navigationObj == null) ? navigationObj = new NavigateMethods(driver) : navigationObj;
	}

	public ConfigFileReader getConfigFileReader() {
		return (configFileReader == null) ? configFileReader = new ConfigFileReader() : configFileReader;
	}

	public AssertionMethods getAssertionMethods() {
		return (assertionObj == null) ? assertionObj = new AssertionMethods(driver) : assertionObj;
	}

	public ClickElementsMethods getClickElementsMethods() {
		return (clickObj == null) ? clickObj = new ClickElementsMethods(driver) : clickObj;
	}

	public InputMethods getInputMethods() {
		return (inputObj == null) ? inputObj = new InputMethods(driver) : inputObj;
	}

	public JsonDataReader getJsonDataReader() {
		return (jsonDataReader == null) ? jsonDataReader = new JsonDataReader() : jsonDataReader;
	}




	
	final static Logger log = LoggerFactory.getLogger(BaseClass.class);
	

	
	public void mouseOver(String mouseElement)
	{
		WebElement element = driver.findElement(By.xpath(mouseElement));
		 
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
	}
	
	public boolean isDisplayed(String xpath)
	{
		return driver.findElement(By.xpath(xpath)).isDisplayed();
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}

	public void pageRefresh()
	{
		driver.navigate().refresh();
	}

	public void pageBack()
	{
		driver.navigate().back();
	}

	public void pageForward()
	{
		driver.navigate().forward();
	}

	public static void screenShot(String fileName) {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void PageScrolldown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,300)", "");

	}

	public void PageScrollup() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-300)", "");
	}
}
