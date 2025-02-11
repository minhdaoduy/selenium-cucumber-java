package info.seleniumcucumber.steps;

import info.seleniumcucumber.pageAndActionObjects.AbstractPage;
import info.seleniumcucumber.pageAndActionObjects.LoginPage;
import io.cucumber.java.en.Given;
//import org.junit.Assert;
import org.testng.Assert;

public class LoginSteps extends AbstractPage {

    @Given("^I should get logged-in$")
    public void should_logged_in() throws NoSuchFieldException {
        final LoginPage loginPage = new LoginPage();
        Assert.assertEquals("You logged into a secure area!", loginPage.getMessage().getText().split("\n")[0].trim());
    }
}
