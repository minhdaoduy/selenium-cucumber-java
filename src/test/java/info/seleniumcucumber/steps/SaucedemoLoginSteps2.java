package info.seleniumcucumber.steps;

import info.seleniumcucumber.cucumber.TestContext;
import info.seleniumcucumber.managers.FileReaderManager;
import info.seleniumcucumber.pageAndActionObjects.AbstractPage;
import info.seleniumcucumber.pageAndActionObjects.Saucedemo_SignInPage;
import info.seleniumcucumber.pageAndActionObjects.Saucedemo_SignInPage2;
import info.seleniumcucumber.testDataTypes.UserLogin;
import io.cucumber.java.en.When;

public class SaucedemoLoginSteps2 {
    Saucedemo_SignInPage2 saucedemo_SignInPage;
    public SaucedemoLoginSteps2(TestContext context) {

        saucedemo_SignInPage = context.getPageObjectManager().getSaucedemo_SignInPage();
    }

    @When("I login saucedemo with {string}")
    public void i_login_saucedemo_with(String name) throws NoSuchFieldException {
//        Predicate<HttpRequest> uriPredicate = httpRequest -> httpRequest.getUri().contains("your-domain.com");
//        var interceptor = new NetworkInterceptor(
//                getDriver(),
////                Route.matching(httpRequest -> true)
//                Route.matching(uriPredicate)
//                        .to(()-> req -> new HttpResponse()
//                                .setStatus(404)
//                                .setContent(Contents.utf8String("Site is being hacked")))
//        );
        UserLogin userLogin = FileReaderManager.getInstance().getJsonReader().getUserLoginByName(name);
        saucedemo_SignInPage.signIn(userLogin);
    }

}
