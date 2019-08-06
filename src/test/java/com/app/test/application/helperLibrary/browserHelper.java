//Created by Barath Kumar on 2-Aug-2019

package com.app.test.application.helperLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserHelper {

    public static void setBrowserProp(String browserName)
    {

    	System.out.println("browserName: "+browserName);
    	
    	if (browserName.equalsIgnoreCase("chrome"))
    	{
			WebDriverManager.chromedriver().version("2.40").setup();
			testHooksHelper.WEB_DRIVER = new ChromeDriver();

//			For standalone Chrome setup at local
//			System.setProperty("webdriver.chrome.driver", ".//src/test/resources/driverFiles/chromedriver.exe");
//			testHooksHelper.WEB_DRIVER = new ChromeDriver();
    	}
//    	else if (browserName.equalsIgnoreCase("IE"))
//    	{
//			For standalone IE setup
//			WebDriverManager.iedriver().setup();
    	//			For standalone IE setup at local
//        	System.setProperty("webdriver.ie.driver", ".//<IE driver path here>");
//        	testHooksHelper.WEB_DRIVER = new InternetExplorerDriver();
//    	}
//    	else if (browserName.equalsIgnoreCase("firefox"))
//    	{
//			For standalone Firefox setup
//			WebDriverManager.firefoxdriver().setup();
//			testHooksHelper.WEB_DRIVER = new FirefoxDriver();
		//			For standalone Firefox setup at local
//        	System.setProperty("webdriver.firefox.driver", ".//<Firefox Gecko driver path here>");
//        	testHooksHelper.WEB_DRIVER = new FirefoxDriver();
//    	}
    }

}
