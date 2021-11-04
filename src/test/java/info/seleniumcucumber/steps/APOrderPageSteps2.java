package info.seleniumcucumber.steps;

import info.seleniumcucumber.cucumber.TestContext;
import info.seleniumcucumber.pageAndActionObjects.APOrderPage;
import info.seleniumcucumber.pageAndActionObjects.APOrderPage2;
import info.seleniumcucumber.pageAndActionObjects.AbstractPage;
import info.seleniumcucumber.utils.TestCaseFailed;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class APOrderPageSteps2 {

	APOrderPage2 orderPage;

	public APOrderPageSteps2(TestContext context)
	{
		orderPage = context.getPageObjectManager().getAPOrderPage();
	}
	
	@Then("^I should see my order page$")
	public void i_should_see_my_order_page() throws TestCaseFailed {
		
		orderPage.verifyOrderPageTitle();
	}
	
	@When("^I choose proceed to checkout on order page$")
	public void i_choose_proceed_to_checkout_on_order_page() throws NoSuchFieldException {
		
		orderPage.selectProceedToCheckOut();
		orderPage.selectProceedToCheckOut();
		orderPage.agreeTermsAndConditions();
		orderPage.selectProceedToCheckOut();
	    
	}
	
	@When("^I choose the payment method cheque$")
	public void i_choose_the_payment_method_cheque() throws NoSuchFieldException {
	    orderPage.selectPayByCheckMethod();
	}
	
	@When("^I confirm my order$")
	public void i_confirm_my_order() throws NoSuchFieldException {
	    orderPage.selectConfirmMyOrder();
	}

}
