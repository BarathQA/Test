/*Added by barath Kumar
   Purpose : This class is created for POM  - ShoppingOrderHistoryPage
* */

package com.app.test.application.pageObjectLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.util.List;

public class ShoppingOrderHistoryPage extends basePage  {


/* =====================================================================================
    Methods Section
* ======================================================================================*/

    public ShoppingOrderHistoryPage(WebDriver webDriver) {
        super(webDriver);
    }


    /**
     * Method to verify the order history
     * @returnValue - Boolean value - True or False
     */


//  Crosss verify the Order details on payment confirmation with the order confirmation details in the order history
    public boolean verifyOrderHistory() {
        List<WebElement> webtableRows = driver.findElements(By.xpath("//*[@id='order-list']/tbody/tr"));
        boolean flag = false;
        for (int i = 1; i < webtableRows.size(); i++) {
            //Cross verify the Order details on payment confirmation with the order confirmation details in the order history
            if (ShoppingOrderPage.orderDetails.contains(webtableRows.get(i).findElement(By.xpath("//td[1]")).getText())
                    && ShoppingOrderPage.orderDetails.contains(webtableRows.get(i).findElement(By.xpath("//td[3]")).getText())) {
                System.out.println("Order details successfully verified between Order details on payment confirmation with the Order History page details");
                System.out.println("Order Number:- " + webtableRows.get(i).findElement(By.xpath("//td[1]")).getText());
                System.out.println("Order Date :- " + webtableRows.get(i).findElement(By.xpath("//td[3]")).getText());
                flag = true;
                break;
            }
        }

        return flag;


    }


}
