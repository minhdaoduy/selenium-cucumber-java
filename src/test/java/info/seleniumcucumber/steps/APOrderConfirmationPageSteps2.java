package info.seleniumcucumber.steps;

import info.seleniumcucumber.cucumber.TestContext;
import info.seleniumcucumber.pageAndActionObjects.APOrderConfirmationPage;
import info.seleniumcucumber.pageAndActionObjects.APOrderConfirmationPage2;
import info.seleniumcucumber.pageAndActionObjects.AbstractPage;
import info.seleniumcucumber.utils.TestCaseFailed;
import io.cucumber.java.en.Then;

public class APOrderConfirmationPageSteps2 {

	APOrderConfirmationPage2 orderConfirmationPage;

	public APOrderConfirmationPageSteps2(TestContext context)
	{
		orderConfirmationPage = context.getPageObjectManager().getAPOrderConfirmationPage();
	}
	
	@Then("^I should see order confirmation page$")
	public void i_should_see_order_confirmation_page() throws TestCaseFailed {
	    orderConfirmationPage.verifyOrderConfirmationPageTitle();
	}
	
	@Then("^validate the payment amount$")
	public void validate_the_payment_amount() throws NoSuchFieldException {
		orderConfirmationPage.verifyPaymentAmount();
	    
	}
	

}
