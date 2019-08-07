/*Added by barath Kumar
   Purpose : This class is created for POM  - Loginspage
* */
package com.app.test.application.pageObjectLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoginPage extends basePage {

    /* =====================================================================================
        Variables and OR section
    * ======================================================================================*/
    @FindBy(css = "a[class='login']")
    public WebElement SignIn;

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "passwd")
    public WebElement passwordField;


    @FindBy(id = "SubmitLogin")
    public WebElement signInButton;


/* =====================================================================================
    Methods Section
* ======================================================================================*/

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnSignInLink() {
        SignIn.click();

    }


    public void clickOnSignInButton(List<String> inputDetails) {

        System.out.println(inputDetails.get(0));
        System.out.println(inputDetails.get(1));
        emailField.sendKeys(inputDetails.get(0));
        passwordField.sendKeys(inputDetails.get(1));
        signInButton.click();

    }



}