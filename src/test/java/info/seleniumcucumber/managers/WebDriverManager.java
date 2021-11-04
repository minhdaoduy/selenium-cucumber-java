//package info.seleniumcucumber.managers;
//
//import cucumber.api.Scenario;
//import enums.DriverType;
//import enums.EnvironmentType;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import java.net.MalformedURLException;
//import java.util.concurrent.TimeUnit;
//
//public class WebDriverManager {
//  public WebDriver driver;
//  private static DriverType driverType;
//  private static EnvironmentType environmentType;
//  private static final String USERNAME = "praveenkumar_dandu";
//  private static final String ACCESS_KEY = "15d236a2-9b80-42e2-870b-c6139e0360f3";
//  private static final String URL =
//      "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
//
//  public WebDriverManager() {
//    driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
//    environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
//  }
//
//  public WebDriver getDriver() throws MalformedURLException {
//    if (driver == null) driver = createDriver();
//    return driver;
//  }
//
//  public WebDriver createDriver() throws MalformedURLException {
//    switch (environmentType) {
//      case LOCAL:
//        driver = createLocalDriver();
//        break;
//        //      case REMOTE:
//        //        driver = createRemoteDriver();
//        //        break;
//    }
//    return driver;
//  }
//
//  private WebDriver createLocalDriver() {
//    switch (driverType) {
//      case FIREFOX:
//        System.setProperty(
//            "webdriver.gecko.driver", System.getProperty("user.dir") + "/driver/geckodriver");
//        driver = new FirefoxDriver();
//        break;
//      case CHROME:
//        System.setProperty(
//            "webdriver.chrome.driver",
//            System.getProperty("user.dir") + "/driver/chromedriver_mac_2");
//        driver = new ChromeDriver();
//        break;
//        //		case INTERNETEXPLORER : driver = new InternetExplorerDriver();
//    }
//
//    if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
//      driver.manage().window().maximize();
//    driver
//        .manage()
//        .timeouts()
//        .implicitlyWait(
//            FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
//            TimeUnit.SECONDS);
//    return driver;
//  }
//
////  private WebDriver createRemoteDriver() throws MalformedURLException {
////    DesiredCapabilities caps = DesiredCapabilities.chrome();
////    caps.setCapability("platform", "Windows 10");
////    caps.setCapability("version", "latest");
////    caps.setCapability("platform", "macOS 10.13");
////    caps.setCapability("version", "latest");
////    driver = new RemoteWebDriver(new java.net.URL(URL), caps);
////    if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
////      driver.manage().window().maximize();
////    driver
////        .manage()
////        .timeouts()
////        .implicitlyWait(
////            FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
////            TimeUnit.SECONDS);
////    return driver;
////
////    // throw new RuntimeException("RemoteWebDriver is not yet implemented");
////  }
//
//  public void quitDriver(Scenario scenario) {
//    if (scenario.isFailed()) {
//      byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//      scenario.embed(screenshotBytes, "image/png");
//    }
//    driver.close();
//    driver.quit();
//  }
//}
