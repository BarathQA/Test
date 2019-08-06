package com.app.test.application.stepDefLibrary;

import com.app.test.application.pageObjectLibrary.AccountsPage;
import com.app.test.application.pageObjectLibrary.LoginPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static com.app.test.application.helperLibrary.changeToHelper.changeToArrayList;
import static com.app.test.application.helperLibrary.testHooksHelper.WEB_DRIVER;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


public class LoginStepDefinition {

    //Initializing the pages & page elements used in this feature & scenarios
//    LoginPage alp = new LoginPage();

    LoginPage login = new LoginPage(WEB_DRIVER);
    AccountsPage accountsPage = new AccountsPage(WEB_DRIVER);

    //Scenario:
    @Given("^User is on Login Page$")
    public void User_is_on_Login_Page() throws Throwable {
        //Click on SIgnIn Link
        login.clickOnSignInLink();
    }
    @When("^User logs into application with valid credentials$")
    public void User_logs_into_application_with_valid_credentials(DataTable credIp) throws Throwable {

        login.clickOnSignInButton(changeToArrayList(credIp));
    }

    @Then("^User should be logged in$")
    public void isLoginPageDisplayed(){
        assertThat(WEB_DRIVER.getCurrentUrl(),containsString(accountsPage.getUrl()));
        assertNotNull(accountsPage.verifyLogin());
    }

}