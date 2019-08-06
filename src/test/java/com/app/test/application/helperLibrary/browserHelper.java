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

    	}

    }

}
