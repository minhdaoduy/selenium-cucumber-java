package info.seleniumcucumber.utils;

import info.seleniumcucumber.pageAndActionObjects.AbstractPage;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConfigurationMethods extends AbstractPage {


    /**
     * Method to print desktop configuration
     */
    public void printDesktopConfiguration() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
        Calendar cal = Calendar.getInstance();

        System.out.println("Following are machine configurations : \n");
        System.out.println("Date (MM/DD/YYYY) and Time (HH:MM:SS) : " + dateFormat.format(cal.getTime()));

        Capabilities cap = (Capabilities) ((RemoteWebDriver) getDriver()).getCapabilities();
        System.out.println("Browser : " + cap.getBrowserName());
        System.out.println("Platform : " + cap.getPlatform());
    }
}
