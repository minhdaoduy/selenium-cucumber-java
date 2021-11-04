package info.seleniumcucumber.pageAndActionObjects;

import info.seleniumcucumber.Base.BaseClass;
import info.seleniumcucumber.utils.TestCaseFailed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class APMyAccountPage2 {

	private String pageTitle = "My account - My Store";
	WebDriver driver;
	BaseClass baseClass;

	public APMyAccountPage2(WebDriver driver)
	{
		this.driver = driver;
		baseClass = new BaseClass(driver);
	}

	@FindBy(how = How.XPATH, using = "//*[@id='block_top_menu']//a")
	private WebElement lnkWomen;

	@FindBy(how = How.XPATH, using = "//*[@id='block_top_menu']//a[@title='T-shirts']")
	private WebElement tShirts_link;
	
	public void verifyMyAccountPageTitle() throws TestCaseFailed
	{
		baseClass.getAssertionMethods().checkTitle(pageTitle, true);
	}
	
	public void navigateTo_TshirtsPage() throws NoSuchFieldException
	{
		baseClass.getNavigateMethods().hoverOverElement(lnkWomen);
		baseClass.getClickElementsMethods().click(tShirts_link);
	}

}
