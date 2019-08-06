/*Added by barath Kumar
   Purpose : This class is created for POM  - Accountspage
* */

package com.app.test.application.pageObjectLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class AccountsPage extends basePage {


    /* =====================================================================================
        Variables and OR section
    * ======================================================================================*/
    String Mylogin;

    @FindBy(
            css = "a[title='Information']"
    )
    public WebElement personalInformationTab;

    @FindBy(
            css = "span[class='navigation_page']"
    )
    public WebElement navigationPage;

    @FindBy(
            id = "firstname"
    )
    public WebElement firstNameField;

    @FindBy(
            id = "old_passwd"
    )
    public WebElement oldPasswordField;

    @FindBy(
            id = "passwd"
    )
    public WebElement newPasswordField;

    @FindBy(
            id = "confirmation"
    )
    public WebElement confirmPasswordField;

    @FindBy(
            css = "button[name='submitIdentity']"
    )
    public WebElement saveInformationButtton;

    @FindBy(
            css = "p[class*='alert-success']"
    )
    public WebElement successInfoSavedMessage;

    @FindBy(
            id = "block_top_menu"
    )
    public WebElement NavigationBar;

    @FindBy(
            xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a"
    )
    public WebElement category;

    @FindBy(
            css = "#header > div.nav > div > div > nav > div:nth-child(1) > a > span"
    )
    public WebElement loginName;

    public static String firstName = null;

    public String getUrl() {
        return "/index.php?controller";
    }

/* =====================================================================================
    Methods Section
* ======================================================================================*/

    /**
     * Method created to get the personla Information Update Confirmation Message
     *
     * @returnValue - String value of the message displayed
     */
    public String getSuccessMessage() {
        return successInfoSavedMessage.getText();

    }

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to click on Personal information tab on Accounts page
     */
    public void clickOnPersonalInformation() {
        personalInformationTab.click();

    }

    //  Method to return the navigation page
    public String getNavigationPage() {
        return navigationPage.getText();
    }


    public String enterFirstName(List<String> inputDetails) {
        firstNameField.clear();
        firstNameField.sendKeys(inputDetails.get(0));
        return firstName;
    }

    public void enterPasswordFields(List<String> inputDetails) {

        oldPasswordField.sendKeys(inputDetails.get(1));

    }

    public void submitInformation() {
        saveInformationButtton.click();
    }


    public void clickTabForNavigation(String category) {
        List<WebElement> webElementList = this.NavigationBar.findElements(By.tagName("li"));

        for (int i = 0; i < webElementList.size(); ++i) {
            if (((WebElement) webElementList.get(i)).getText().equalsIgnoreCase(category)) {
                ((WebElement) webElementList.get(i)).click();
            }
        }


    }

    public String verifyLogin() {
        Mylogin =loginName.getText();
        return Mylogin;
    }



}
