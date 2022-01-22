package com.aspire.pages;

import com.aspire.helper.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary o-kanban-button-new']")
    private WebElement newProductsButton;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary o_form_button_save']")
    private WebElement saveProductButton;

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary o_form_button_edit']")
    private WebElement editProductButton;

    @FindBy(how = How.NAME, using = "name")
    private WebElement productNameText;

    public void addNewProduct() throws InterruptedException {

        try {

            Helper.elementIsVisible(driver, newProductsButton);
            newProductsButton.click();
            Helper.implicitwait(driver);

            productNameText.sendKeys("Automation_product");
            Helper.implicitwait(driver);

            saveProductButton.click();
            Helper.implicitwait(driver);

        } catch (Exception exception) {
            exception.getMessage();
        }

    }

    public boolean editButtonDisplayed() {
        return editProductButton.isDisplayed();
    }
}
