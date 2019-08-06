/*Added by barath Kumar
 */
package com.app.test.application.pageObjectLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	
	public WebDriver driver;
	final WebDriverWait driverwait;
	
	 public basePage(WebDriver driver) {
	        this.driver = driver;
	        this.driverwait = new WebDriverWait(driver,45);
	        PageFactory.initElements(driver, this);
	    }


	 public WebElement findElementbyClassxPath(String xPath) {
		driverwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
		WebElement elmnt = driver.findElement(By.xpath(xPath)); 
		return elmnt;
	 }
	 
    public void clickElementbyJS(WebElement wElmnt) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", wElmnt);
    }

    public void clickElementXpathbyJS(String elmtXpath) {
        WebElement wElmnt = driver.findElement(By.xpath(elmtXpath));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", wElmnt);
    }
    
    public void waitUntilnGFinishHttpCalls() throws InterruptedException {
        ExpectedCondition<Boolean> pendingHttpCallsCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular !== undefined) && (angular.element(document).injector() !== undefined) && (angular.element(document).injector().get('$http').pendingRequests.length === 0)").toString());
            }
        };
        
        driverwait.until(pendingHttpCallsCondition);
    }

     //common method created for switching back to the original window
    public String switchwindowback(){
//        try {
            String winHandleBefore = driver.getWindowHandle();
            driver.close();
            //Switch back to original browser (first window)
            driver.switchTo().window(winHandleBefore);
            //continue with original browser (first window)
//        }catch(Exception e){
//            return Constants.KEYWORD_FAIL+ "Unable to Switch to main window" + e.getMessage();
//        }
        return winHandleBefore;
    }
}