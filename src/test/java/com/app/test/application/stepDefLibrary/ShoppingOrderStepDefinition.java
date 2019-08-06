package com.app.test.application.stepDefLibrary;

import com.app.test.application.pageObjectLibrary.ShoppingOrderPage;
import cucumber.api.java.en.When;
import static com.app.test.application.helperLibrary.testHooksHelper.WEB_DRIVER;

public class ShoppingOrderStepDefinition {

    ShoppingOrderPage shoppingOrderPage = new ShoppingOrderPage(WEB_DRIVER);

    @When("^User completes Tshirt purchase$")
    public void user_completes_the_purchase() {
        shoppingOrderPage.proceedOnSummary();
        shoppingOrderPage.proceedOnAddress();
        shoppingOrderPage.selectAgreeCheckBox();
        shoppingOrderPage.proceedOnShipping();
    }

    @When("^User navigate back to the Order History Page$")
    public void User_navigate_back_to_the_Order_History_Page(){
        shoppingOrderPage.getTotalPriceValue();
        shoppingOrderPage.selectPaymentMethod();
        shoppingOrderPage.confirmationOnPayment();
        shoppingOrderPage.getOrderDetails();
        shoppingOrderPage.goToOrderHistory();
    }

}
