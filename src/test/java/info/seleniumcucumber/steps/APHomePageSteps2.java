package info.seleniumcucumber.steps;

import info.seleniumcucumber.cucumber.TestContext;
import info.seleniumcucumber.pageAndActionObjects.APHomePage;
import info.seleniumcucumber.pageAndActionObjects.APHomePage2;
import info.seleniumcucumber.pageAndActionObjects.AbstractPage;
import info.seleniumcucumber.utils.TestCaseFailed;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class APHomePageSteps2 {

  APHomePage2 homePage;

  public APHomePageSteps2(TestContext context) {

    homePage = context.getPageObjectManager().getAPHomePage();
  }
      @Given("^I want to go to automationpractice website$")
      public void i_want_to_go_to_automationpractice_website() {

          homePage.navigateTo_ApHomePage();

      }

      @Given("^verify the mystore title$")
      public void verify_the_mystore_title() throws TestCaseFailed {

          homePage.verifyAPHomePageTitle();
      }

      @When("^I click on sign in$")
      public void i_click_on_sign_in() throws NoSuchFieldException {

          homePage.navigateTo_LoginPage();

      }

}
