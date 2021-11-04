package info.seleniumcucumber.managers;

import info.seleniumcucumber.pageAndActionObjects.*;
import info.seleniumcucumber.pageAndActionObjects.APIs.RegisterUserActions;
import org.openqa.selenium.WebDriver;
import info.seleniumcucumber.pageAndActionObjects.*;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {
	private WebDriver driver;
	private APHomePage2 homePage;
	private APMyAccountPage2 myAccountPage;
	private APSignInPage2 signInPage;
	private APOrderConfirmationPage2 orderConfirmationPage;
	private APOrderPage2 orderPage;
	private APTshirtsSectionPage2 tShirtsSectionPage;
	private Saucedemo_SignInPage2 saucedemo_SignInPage;
	private Weather2 weather;
	
	
	public PageObjectManager(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public APHomePage2 getAPHomePage(){
		return (homePage == null) ? homePage = new APHomePage2(driver) : homePage;
	}
	
	public APMyAccountPage2 getAPMyAccountPage(){
		return (myAccountPage == null) ? myAccountPage = new APMyAccountPage2(driver) : myAccountPage;
	}
	
	public APOrderConfirmationPage2 getAPOrderConfirmationPage(){
		return (orderConfirmationPage == null) ? orderConfirmationPage = new APOrderConfirmationPage2(driver) : orderConfirmationPage;
	}
	
	public APOrderPage2 getAPOrderPage(){
		return (orderPage == null) ? orderPage = new APOrderPage2(driver) : orderPage;
	}
	
	public APSignInPage2 getAPSignInPage(){
		return (signInPage == null) ? signInPage = new APSignInPage2(driver) : signInPage;
	}
	
	public APTshirtsSectionPage2 getAPTshirtsSectionPage(){
		return (tShirtsSectionPage == null) ? tShirtsSectionPage = new APTshirtsSectionPage2(driver) : tShirtsSectionPage;
	}

	public Saucedemo_SignInPage2 getSaucedemo_SignInPage(){
		return (saucedemo_SignInPage == null) ? saucedemo_SignInPage = new Saucedemo_SignInPage2() : saucedemo_SignInPage;
	}


	public Weather2 getWeather(){
		return (weather == null) ? weather = new Weather2(driver) : weather;
	}
}
