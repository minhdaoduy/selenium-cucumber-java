package info.seleniumcucumber.pageAndActionObjects;

import info.seleniumcucumber.Base.BaseClass;
import info.seleniumcucumber.cucumber.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class Weather2 {
	WebDriver driver;
	BaseClass baseClass;

	public Weather2(WebDriver driver)
	{
		this.driver = driver;
		baseClass = new BaseClass(driver);
	}

	@FindBy(how = How.ID, using = "LocationSearch_input")
	private WebElement txtLocationSearch;

	@FindBy(how = How.XPATH, using = "//*[@id='LocationSearch_listbox']/button")
	private List<WebElement> btnResultList;

	@FindBy(how = How.XPATH, using = "//*[@id='LocationSearch_listbox']/button[1]")
	private WebElement btnResult;
	
	public void inputKeywordIntoSearchField(String keyword) throws NoSuchFieldException
	{
		baseClass.getClickElementsMethods().click(txtLocationSearch);
		baseClass.getInputMethods().enterText(txtLocationSearch, keyword);
	}

	public String getTextListResult() throws NoSuchFieldException
	{
		return baseClass.getAssertionMethods().getElementText(btnResult);
	}

	public String verifySearchResult(String expectedString) throws NoSuchFieldException
	{
		return baseClass.getAssertionMethods().getElementText(btnResultList.get(0));
	}

}
