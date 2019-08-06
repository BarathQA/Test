

/*Added by barath Kumar
   Purpose : This hooks file will act as a hook to the project.All the setup and teardown
   configurations are done here
* */
package com.app.test.application.helperLibrary;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.app.test.application.helperLibrary.browserHelper.setBrowserProp;
import com.cucumber.listener.Reporter;
import java.io.File;


public class testHooksHelper  {

	public static WebDriver WEB_DRIVER;
    public static WebDriverWait WEB_DRIVER_WAIT;
    ConfigFileReader configFileReader = new ConfigFileReader();

    @Before
    public void beforeScenario(Scenario scenario) {
    	setBrowserProp(configFileReader.getApplicationBrowser());
//    	WEB_DRIVER_WAIT = new WebDriverWait(WEB_DRIVER, 45);
    	WEB_DRIVER.manage().deleteAllCookies();
        WEB_DRIVER.manage().window().maximize();
        WEB_DRIVER.get(configFileReader.getApplicationUrl());
    }

    @After
    /*This method is created to report the failed scenarios*/
    public void afterScenario(Scenario scenario) throws InterruptedException {

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) WEB_DRIVER).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        Thread.sleep(3000);
        WEB_DRIVER.quit();
    }
    /*This method is created for the reporter to get the path of the extent config xml for writing
    the Extent report*/
      public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(new ConfigFileReader().getExtentReportConfigPath()));
    }
}