package com.app.test.application.stepDefLibrary;

import com.app.test.application.pageObjectLibrary.ShoppingOrderHistoryPage;
import cucumber.api.java.en.Then;
import org.hamcrest.core.IsEqual;
import static com.app.test.application.helperLibrary.testHooksHelper.WEB_DRIVER;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingOrderHistoryStepDefinition {


    ShoppingOrderHistoryPage shoppingOrderHistoryPage = new ShoppingOrderHistoryPage(WEB_DRIVER);

    @Then("^User should see that his Order is displayed in order history page$")
    public void User_should_see_that_his_Order_is_displayed_in_order_history_page() {

        assertThat(shoppingOrderHistoryPage.verifyOrderHistory(), IsEqual.equalTo(true));

    }

}
