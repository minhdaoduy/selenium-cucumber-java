package info.seleniumcucumber.pageAndActionObjects;

import info.seleniumcucumber.Base.BaseClass;
import info.seleniumcucumber.utils.TestCaseFailed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class APOrderPage2 {

	private String pageTitle = "Order - My Store";
	WebDriver driver;
	BaseClass baseClass;

	public APOrderPage2(WebDriver driver)
	{
		this.driver = driver;
		baseClass = new BaseClass(driver);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='center_column']//span[contains(text(),'Proceed to checkout')]")
	private WebElement btnProceedToCheckout;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'I agree to the terms of service and will adhere to them unconditionally.')]")
	private WebElement lblReadTheTerms;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Pay by check ')]")
	private WebElement lnkPayByCheck;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'I confirm my order')]")
	private WebElement btnConfirmOrder;

	public void verifyOrderPageTitle() throws TestCaseFailed
	{
		baseClass.getAssertionMethods().checkTitle(pageTitle, true);
	}
	
	public void selectProceedToCheckOut() throws NoSuchFieldException
	{
		baseClass.getClickElementsMethods().click(btnProceedToCheckout);
	}
	
	public void agreeTermsAndConditions() throws NoSuchFieldException
	{
		baseClass.getClickElementsMethods().click(lblReadTheTerms);
	}
	
	public void selectPayByCheckMethod() throws NoSuchFieldException
	{
		baseClass.getClickElementsMethods().click(lnkPayByCheck);
	}
	
	public void selectConfirmMyOrder() throws NoSuchFieldException
	{
		baseClass.getClickElementsMethods().click(btnConfirmOrder);
	}

}
