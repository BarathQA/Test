package com.app.test.application.stepDefLibrary;

import com.app.test.application.pageObjectLibrary.AccountsPage;
import com.app.test.application.pageObjectLibrary.ShoppingCategoryPage;
import com.app.test.application.helperLibrary.testHooksHelper;
import cucumber.api.java.en.Given;


public class ShoppingCategoryStepDefinition {

    AccountsPage accountsPage = new AccountsPage(testHooksHelper.WEB_DRIVER);
    ShoppingCategoryPage shoppingCategoryPage = new ShoppingCategoryPage(testHooksHelper.WEB_DRIVER);

    //Scenario:
    @Given("User navigates to the \"([^\"]*)\" section and selects the t-shirt$")

    public void User_navigates_to_the_TShirt_section_and_selects_the_tshirt(String shoppingCategory){
        accountsPage.clickTabForNavigation(shoppingCategory);
        shoppingCategoryPage.AddToCart();
        shoppingCategoryPage.proceedOnPopUp();
    }

}
