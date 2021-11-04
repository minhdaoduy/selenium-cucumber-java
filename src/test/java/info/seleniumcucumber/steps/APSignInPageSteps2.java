package info.seleniumcucumber.steps;

import info.seleniumcucumber.cucumber.TestContext;
import info.seleniumcucumber.pageAndActionObjects.APSignInPage;
import info.seleniumcucumber.pageAndActionObjects.APSignInPage2;
import info.seleniumcucumber.pageAndActionObjects.AbstractPage;
import info.seleniumcucumber.testDataTypes.Customer;
import info.seleniumcucumber.managers.FileReaderManager;
import info.seleniumcucumber.utils.TestCaseFailed;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class APSignInPageSteps2 {
	APSignInPage2 signInPage;

	public APSignInPageSteps2(TestContext context) {
		signInPage = context.getPageObjectManager().getAPSignInPage();
	}
	
	@Then("^I should see the login page$")
	public void i_should_see_the_login_page() throws TestCaseFailed {
		
		signInPage.verifySignInPageTitle();
	    
	}
	
	@When("^I enter \"([^\"]*)\" login credentials$")
	public void i_enter_login_credentials(String customerName) throws NoSuchFieldException {
		Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
		signInPage.signInOperation(customer);
	}

}
