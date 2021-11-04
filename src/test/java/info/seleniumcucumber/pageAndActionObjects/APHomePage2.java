package info.seleniumcucumber.pageAndActionObjects;

import info.seleniumcucumber.Base.BaseClass;
import info.seleniumcucumber.utils.TestCaseFailed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class APHomePage2 {
	WebDriver driver;
	BaseClass baseClass;


	public APHomePage2(WebDriver driver)
	{
		this.driver = driver;
		baseClass = new BaseClass(driver);
	}

	private String pageTitle = "My Store";
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space() = 'Sign in']")
	private WebElement signIn;
	
	public void navigateTo_ApHomePage()
	{
		baseClass.getNavigateMethods().navigateTo(baseClass.getConfigFileReader().getAPApplicationUrl());
	}
	
	public void verifyAPHomePageTitle() throws TestCaseFailed
	{

		baseClass.getAssertionMethods().checkTitle(pageTitle,true);
	}
	
	public void navigateTo_LoginPage() throws NoSuchFieldException
	{

		baseClass.getClickElementsMethods().click(signIn);
	}

}
