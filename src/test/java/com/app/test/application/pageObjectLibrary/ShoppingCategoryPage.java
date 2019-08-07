/*Added by barath Kumar
   Purpose : This class is created for POM  - ShoppingCategoryPage
* */
package com.app.test.application.pageObjectLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;

public class ShoppingCategoryPage extends BasePage {


/* =====================================================================================
    Variables and OR section
* ======================================================================================*/

    @FindBy(css = "a[title='Add to cart']")
    public WebElement addToCartButton;


    @FindBy(css = "a[title='Proceed to checkout']")
    public WebElement proceedToCheckOutButton;


/* =====================================================================================
    Methods Section
* ======================================================================================*/


    public ShoppingCategoryPage(WebDriver webDriver) {
        super(webDriver);
    }


    public String getUrl() {
        return "?id_category=5&controller=category";
    }

    /**
     * Method to add the item to cart
     */
    public void AddToCart() {
        addToCartButton.click();
    }

    /**
     * Method to click Proceed to Checkout button in the PeoceedOnPopup window
     */
    public void proceedOnPopUp() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(" arguments[0].click();", proceedToCheckOutButton);
    }


}
