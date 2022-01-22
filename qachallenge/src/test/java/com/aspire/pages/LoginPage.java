package com.aspire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.NAME, using = "login")
    private WebElement userName;

    @FindBy(how = How.NAME, using = "password")
    private WebElement password;

    @FindBy(how = How.XPATH, using = "//*[text()='Log in']")
    private WebElement logInButton;

    @FindBy(how = How.XPATH, using = "//*[@class='alert alert-danger']")
    private WebElement loginErrorMsg;

    // Valid user login
    public HomePage validLogin() {
        try {

            userName.clear();

            userName.sendKeys("user@aspireapp.com");
            Thread.sleep(1000);

            password.sendKeys("@sp1r3app");
            Thread.sleep(1000);

            logInButton.click();
            Thread.sleep(2000);

        } catch (Exception exception) {
            exception.printStackTrace();

        }

        HomePage homePage = new HomePage(driver);
        return homePage;
    }

    // InValid user login
    public void invalidLogin() {
        try {

            userName.clear();
            userName.sendKeys("user@aspireapp.com");
            Thread.sleep(1000);

            password.sendKeys("@sp1r3app@");
            Thread.sleep(1000);

            logInButton.click();
            Thread.sleep(2000);

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    public boolean loginErrorMessageDisplayed() {
        return loginErrorMsg.isDisplayed();
    }

}
