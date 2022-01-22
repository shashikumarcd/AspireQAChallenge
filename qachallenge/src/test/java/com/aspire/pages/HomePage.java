package com.aspire.pages;

import java.util.NoSuchElementException;
import com.aspire.helper.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[text()='Manufacturing']/preceding::div[1]")
    private WebElement manufatureMenuOption;

    @FindBy(how = How.XPATH, using = "//*[text()='Inventory']/preceding::div[1]")
    private WebElement inventoryMenuOption;

    @FindBy(how = How.XPATH, using = "//*[text()='user']/preceding::img")
    private WebElement userProfile;

    @FindBy(how = How.XPATH, using = "//a[text()='Log out']")
    private WebElement logOutButton;

    public void logout() throws InterruptedException {

        try {
            Helper.moveToElement(driver, userProfile);

            Helper.elementIsVisible(driver, userProfile);
            userProfile.click();

            Helper.elementIsVisible(driver, logOutButton);
            logOutButton.click();
            Helper.implicitwait(driver);

        } catch (NoSuchElementException exception) {
            exception.getStackTrace();
        }

    }

    public void gotoInventory() throws InterruptedException {

        try {

            Helper.elementIsVisible(driver, inventoryMenuOption);
            inventoryMenuOption.click();
            Helper.implicitwait(driver);

        } catch (NoSuchElementException exception) {
            exception.getStackTrace();
        }
    }

    public boolean manufatureMenuOptionDisplayed() {
        return manufatureMenuOption.isDisplayed();
    }
}
