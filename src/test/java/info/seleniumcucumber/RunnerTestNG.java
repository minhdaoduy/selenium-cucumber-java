package info.seleniumcucumber;


import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    plugin = {
      "pretty",
      "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//      "json:target/reports/cucumber-json-reports/json-report.json",
//      "html:target/reports/cucumber-html-reports/html-report.html"
    },
    glue = {"info.seleniumcucumber.steps"},
//            features = {"classpath:features/"}
//            features = {"classpath:features/my_first.feature"}
    features = {"src/test/resources/features/Purchase.feature", "src/test/resources/features/Purchase2.feature"}
    //        features = {"src/test/resources/features/api/registeruser.feature"}
    //        features = {"src/test/resources/features/api/login.feature"}
    //        features = {"src/test/resources/features/api/testDB.feature"}
//            features = {"src/test/resources/features/saucedemo-login.feature"}
    //        features = {"src/test/resources/features/weather-intercept.feature"}
    //        features = {"src/test/resources/features/ExecuteAutomationDevTools.feature"}
    )
public class RunnerTestNG  extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
