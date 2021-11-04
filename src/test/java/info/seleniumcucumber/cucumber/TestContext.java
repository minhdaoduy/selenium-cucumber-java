package info.seleniumcucumber.cucumber;

import info.seleniumcucumber.managers.PageObjectManager;
import info.seleniumcucumber.utils.DriverManager;

import java.net.MalformedURLException;

public class TestContext {
	private DriverManager driverManager;
	private PageObjectManager pageObjectManager;
	
	public TestContext() {
		driverManager = new DriverManager();
		pageObjectManager = new PageObjectManager(driverManager.getDriver());
		
	}
	
	public DriverManager getWebDriverManager()
	{
		return driverManager;
	}
	
	public PageObjectManager getPageObjectManager()
	{
		return pageObjectManager;
	}

}
