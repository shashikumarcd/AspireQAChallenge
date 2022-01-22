package com.aspire.tests;

import com.aspire.components.TestBase;
import com.aspire.pages.HomePage;
import com.aspire.pages.InventoryPage;
import com.aspire.pages.LoginPage;
import com.aspire.pages.ProductsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductTest extends TestBase {

    @Test
    public void addProduct() {

        try {

            LoginPage loginPage = new LoginPage(driver);
            loginPage.validLogin();

            HomePage homePage = new HomePage(driver);

            homePage.gotoInventory();

            InventoryPage inventoryPage = new InventoryPage(driver);
            inventoryPage.gotoProducts();

            ProductsPage productsPage = new ProductsPage(driver);
            productsPage.addNewProduct();

            Assert.assertTrue(productsPage.editButtonDisplayed());

        } catch (Exception exception) {
            exception.getMessage();
        }

    }

}
