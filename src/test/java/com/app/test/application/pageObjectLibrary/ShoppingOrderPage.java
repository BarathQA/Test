/*Added by barath Kumar
   Purpose : This class is created for POM  - ShoppingOrderPage
* */
package com.app.test.application.pageObjectLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingOrderPage extends basePage {

    /* =====================================================================================
        Variables and OR section
    * ======================================================================================*/
    @FindBy(css = "p[class*='cart_navigation clearfix'] a[title='Proceed to checkout']")
    public WebElement Summary_proceedToCheckOut;

    @FindBy(css = "button[name='processAddress']")
    public WebElement Address_proceedToCheckOut;

    @FindBy(id = "cgv")
    public WebElement selectAgreeCheckBox;

    @FindBy(css = "button[name='processCarrier']")
    public WebElement Shipping_proceedToCheckout;

    @FindBy(className = "bankwire")
    public WebElement bankWirePaymentOption;

    @FindBy(className = "cheque")
    public WebElement chequePaymentOption;

    @FindBy(css = "p[class*='cart_navigation'] button[type='submit']")
    public WebElement iConfirmMyOrdertButton;

    @FindBy(css = "div[class='box']")
    public WebElement paymentConfirmationInfo;

    @FindBy(id = "total_price")
    public WebElement totalPrice;

    @FindBy(css = "a[title='Back to orders']")
    public WebElement backToOrderHistoryLink;


    public static String orderDetails;
    public static String totalPriceValue;

    //    ShoppingOrderHistoryPage a= new ShoppingOrderHistoryPage();
    public ShoppingOrderHistoryPage orderHistoryPage = new ShoppingOrderHistoryPage(driver);
    public ShoppingOrderPage(WebDriver webDriver) {
        super(webDriver);
    }

    /* =====================================================================================
        Methods Section
    * ======================================================================================*/
    /**
     * Method to proceed from summary on cart
     */
    public void proceedOnSummary() {

        // Create new WebDriver wait

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Summary_proceedToCheckOut));
        element.click();
    }

    /**
     * Method to click ProceedTOCheckout button under Address section
     */
    public void proceedOnAddress() {
        Address_proceedToCheckOut.click();
    }
    /**
     * Method to click ProceedTOCheckout button under Shipping section
     */
    public void proceedOnShipping() {
        Shipping_proceedToCheckout.click();
    }



    /**
     * Method to click ProceedTOCheckout button under Payment section
     */
    public void selectPaymentMethod() {
        bankWirePaymentOption.click();
    }


    /**
     * Method to select the check box in the Shopping Order Page
     */
    public void selectAgreeCheckBox() {
        selectAgreeCheckBox.click();

    }

    /**
     * Method to get the total price from the order details
     * @returnValue - String value - Total Price
     */
    public String getTotalPriceValue() {
        totalPriceValue = totalPrice.getText();
        System.out.println(totalPriceValue);
        return totalPriceValue;
    }


    /**
     * Method to confirm payment by clicking I confirm My Order Button
     */
    public void confirmationOnPayment() {
        iConfirmMyOrdertButton.click();
    }

    /**
     * Method to get the Order details to verify with the Order history details
     * @return - String value - Order details
     */
    public String getOrderDetails() {
        orderDetails = paymentConfirmationInfo.getText();
        return orderDetails;
    }

    /**
     * Method navigate to History orders
     */

    public ShoppingOrderHistoryPage goToOrderHistory() {
        backToOrderHistoryLink.click();
        return orderHistoryPage;
    }
}
