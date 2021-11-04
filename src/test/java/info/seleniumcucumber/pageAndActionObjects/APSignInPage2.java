package info.seleniumcucumber.pageAndActionObjects;

import info.seleniumcucumber.Base.BaseClass;
import info.seleniumcucumber.testDataTypes.Customer;
import info.seleniumcucumber.utils.TestCaseFailed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class APSignInPage2{

	private String pageTitle = "Login - My Store";
	WebDriver driver;
	BaseClass baseClass;

	public APSignInPage2(WebDriver driver)
	{
		this.driver = driver;
		baseClass = new BaseClass(driver);
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	private WebElement txtEmail;
	
	@FindBy(how = How.XPATH, using = "//input[@id='passwd']")
	private WebElement txtPassword;
	
	@FindBy(how = How.XPATH, using = "//span[normalize-space() = 'Sign in']")
	private WebElement btnSignIn;

	public void verifySignInPageTitle() throws TestCaseFailed
	{
		baseClass.getAssertionMethods().checkTitle(pageTitle, true);
	}
	
	public void signInOperation(Customer customer) throws NoSuchFieldException
	{
		baseClass.getInputMethods().enterText(txtEmail, customer.emailAddress);
		baseClass.getInputMethods().enterText(txtPassword, customer.password);
		baseClass.getClickElementsMethods().click(btnSignIn);
	}

}
