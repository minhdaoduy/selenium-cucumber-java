package info.seleniumcucumber.steps;

import info.seleniumcucumber.cucumber.TestContext;
import info.seleniumcucumber.pageAndActionObjects.APMyAccountPage;
import info.seleniumcucumber.pageAndActionObjects.APMyAccountPage2;
import info.seleniumcucumber.pageAndActionObjects.AbstractPage;
import info.seleniumcucumber.utils.TestCaseFailed;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class APMyAccountPageSteps2 {
	APMyAccountPage2 myAccountPage;

	public APMyAccountPageSteps2(TestContext context) {
		myAccountPage = context.getPageObjectManager().getAPMyAccountPage();
	}

	@Then("^I should see the my account page$")
	public void i_should_see_the_my_account_page() throws TestCaseFailed {
	    myAccountPage.verifyMyAccountPageTitle();
	}
	
	@When("^I choose the option women and choose tshirts$")
	public void i_choose_the_option_women_and_choose_tshirts() throws NoSuchFieldException {
	    myAccountPage.navigateTo_TshirtsPage();
	}

}
