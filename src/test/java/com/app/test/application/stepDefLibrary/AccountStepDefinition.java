package com.app.test.application.stepDefLibrary;

import com.app.test.application.pageObjectLibrary.AccountsPage;

import static com.app.test.application.helperLibrary.testHooksHelper.WEB_DRIVER;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.app.test.application.helperLibrary.changeToHelper.changeToArrayList;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class AccountStepDefinition {

    AccountsPage accountsPage = new AccountsPage(WEB_DRIVER);

    //Scenario:
    @Given("^User navigates to the Firstname field under Personal information section in Accounts Page$")
    public void User_navigates_to_the_Firstname_field_under_Personal_information_section_in_Accounts_Page (){
        accountsPage.clickOnPersonalInformation();
        assertThat(accountsPage.getNavigationPage(),equalTo("Your personal information"));
    }


    @When("^User updates and saves the Firstname$")
    public void User_updates_and_saves_the_Firstname(DataTable modifyUserName) {
        accountsPage.enterFirstName(changeToArrayList(modifyUserName));
        accountsPage.enterPasswordFields(changeToArrayList(modifyUserName));
        accountsPage.submitInformation();
    }

    @Then("^User is displayed with success message \"([^\"]*)\"$")
    public void User_is_displayed_with_success_message(String message) {
        assertThat(accountsPage.getSuccessMessage(),equalTo(message));
    }





}


