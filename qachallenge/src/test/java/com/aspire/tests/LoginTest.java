package com.aspire.tests;

import com.aspire.components.TestBase;
import com.aspire.pages.HomePage;
import com.aspire.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void validLogin() {

        try {

            LoginPage loginPage = new LoginPage(driver);
            loginPage.validLogin();

            HomePage homePage = new HomePage(driver);

            Assert.assertTrue(homePage.manufatureMenuOptionDisplayed());

            homePage.logout();

        } catch (Exception exception) {
            exception.getMessage();
        }

    }

    @Test
    public void inValidLogin() {

        try {

            LoginPage loginPage = new LoginPage(driver);
            loginPage.invalidLogin();

            Assert.assertTrue(loginPage.loginErrorMessageDisplayed());

        } catch (Exception exception) {
            exception.getMessage();
        }

    }

}
