package com.aspire.tests;

import com.aspire.components.TestBase;
import com.aspire.pages.HomePage;
import com.aspire.pages.InventoryPage;
import com.aspire.pages.LoginPage;
import com.aspire.pages.ManufacturingOrderPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ManufacturingOrderTest extends TestBase {
    
    @Test
    public void addNewOrder() {

        try {

            LoginPage loginPage = new LoginPage(driver);
            loginPage.validLogin();

            HomePage homePage = new HomePage(driver);            
            
            homePage.gotoInventory();

            InventoryPage inventoryPage = new InventoryPage(driver);
            inventoryPage.gotoManufacturing();

            ManufacturingOrderPage manOrderPage = new ManufacturingOrderPage(driver);
            manOrderPage.addNewOrder();

            String referenceNo = manOrderPage.getRefernceNo();

            manOrderPage.goToInventory();
            inventoryPage.selectDoneFilterOption();
            Assert.assertTrue(inventoryPage.refernceList().contains(referenceNo));
        
        } catch (Exception exception) {
            exception.getMessage();
        }

    }

}
