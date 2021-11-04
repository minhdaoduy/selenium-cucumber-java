package info.seleniumcucumber.pageAndActionObjects;

import info.seleniumcucumber.Base.BaseClass;
import info.seleniumcucumber.utils.TestCaseFailed;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
//import org.testng.Assert;

public class APOrderConfirmationPage2 {

	public String pageTitle = "Order confirmation - My Store";
	WebDriver driver;
	BaseClass baseClass;

	public APOrderConfirmationPage2(WebDriver driver)
	{
		this.driver = driver;
		baseClass = new BaseClass(driver);
	}

	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'$18.51')]")
	private WebElement btnPaymentAmount;

	public void verifyOrderConfirmationPageTitle() throws TestCaseFailed
	{
		baseClass.getAssertionMethods().checkTitle(pageTitle, true);
	}
	
	public String getPaymentAmount() throws NoSuchFieldException
	{
		return baseClass.getAssertionMethods().getElementText(btnPaymentAmount);
	}
	
	public void verifyPaymentAmount() throws NoSuchFieldException
	{
		Assert.assertEquals(getPaymentAmount(),"$18.51");
	}
}
