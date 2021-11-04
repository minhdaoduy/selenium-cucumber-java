package info.seleniumcucumber.pageAndActionObjects;

import info.seleniumcucumber.Base.BaseClass;
import info.seleniumcucumber.utils.TestCaseFailed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class APTshirtsSectionPage2 {

	WebDriver driver;
	BaseClass baseClass;

	public APTshirtsSectionPage2(WebDriver driver)
	{
		this.driver = driver;
		baseClass = new BaseClass(driver);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'M')]")
	private WebElement lnkTShirtMediumSize;

	public String pageTitle = "T-shirts - My Store";
	
	@FindBy(how = How.XPATH, using = "//a/img[@title='Faded Short Sleeve T-shirts']")
	private WebElement imgMouseoverFadedTShirt;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Add to cart')]")
	private WebElement btnAddToCart;
	
	@FindBy(how = How.XPATH, using = "//*[@id='layer_cart']//span[contains(text(),'Proceed to checkout')]")
	private WebElement btnProceedToCheckout;
	
	public void verifyTshirtsPageTitle() throws TestCaseFailed
	{
		baseClass.getAssertionMethods().checkTitle(pageTitle, true);
	}
	
	public void chooseMediumSize() throws NoSuchFieldException
	{
		baseClass.getClickElementsMethods().click(lnkTShirtMediumSize);
	}
	
	public void addFadedTshirtToCart() throws NoSuchFieldException
	{
		baseClass.getNavigateMethods().hoverOverElement(imgMouseoverFadedTShirt);
		baseClass.getClickElementsMethods().click(btnAddToCart);
	}
	
	public void selectProceedToCheckout() throws NoSuchFieldException
	{
		baseClass.getClickElementsMethods().click(btnProceedToCheckout);
	}

}
