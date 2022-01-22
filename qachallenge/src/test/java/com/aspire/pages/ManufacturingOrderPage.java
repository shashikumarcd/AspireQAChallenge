package com.aspire.pages;

import java.util.List;

import com.aspire.helper.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ManufacturingOrderPage extends BasePage {

    public ManufacturingOrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary o_list_button_add']")
    private WebElement newOrderButton;

    @FindBy(how = How.XPATH, using = "//*[@name='product_id']/div/input")
    private WebElement productFieldInput;

    @FindBy(how = How.XPATH, using = "//*[@id='ui-id-1']/li")
    private List<WebElement> totalLists;

    @FindBy(how = How.XPATH, using = "//*[@class='o_row no-gutters d-flex']/input")
    private WebElement quantityFieldInput;

    @FindBy(how = How.XPATH, using = "//*[@name='qty_producing']")
    private WebElement updateQtyinMarkasDone;

    @FindBy(how = How.ID, using = "o_field_input_1500")
    private WebElement bomFieldInput;

    @FindBy(how = How.XPATH, using = "//*[@class='tab-pane active']/div/div[2]/div/table/tbody/tr[1]/td/a")
    private WebElement addProductComplink;

    @FindBy(how = How.XPATH, using = "//*[@class='tab-pane active']/div/div[2]/div/table/tbody/tr[1]/td[1]/div/div/input")
    private WebElement productInComp;

    @FindBy(how = How.NAME, using = "product_uom_qty")
    private WebElement consuQty;

    @FindBy(how = How.NAME, using = "action_confirm")
    private WebElement confirmButton;

    @FindBy(how = How.XPATH, using = "//*[@class='o_statusbar_buttons']/button[2]")
    private WebElement markAsDoneButton;

    @FindBy(how = How.XPATH, using = "//*[text()='Inventory' and @class='o_menu_brand']")
    private WebElement goToInventory;

    @FindBy(how = How.XPATH, using = "//*[@placeholder='Manufacturing Reference']")
    private WebElement refernceNo;
    

    public void addNewOrder() throws InterruptedException {

        try {

            Helper.elementIsVisible(driver, newOrderButton);
            newOrderButton.click();

            Helper.selectDropDownOption(driver, "Auto_prod", productFieldInput, totalLists);

            Helper.elementIsVisible(driver, quantityFieldInput);
            quantityFieldInput.clear();
            quantityFieldInput.sendKeys("15");

            addProductComplink.click();
            Helper.implicitwait(driver);

            Helper.selectDropDownOption(driver, "Auto_prod", productInComp, totalLists);

            confirmButton.click();
            Helper.implicitwait(driver);

            updateQtyinMarkasDone.clear();
            updateQtyinMarkasDone.sendKeys("15");
            Helper.implicitwait(driver);

            markAsDoneButton.click();
            Helper.implicitwait(driver);

        } catch (Exception exception) {
            exception.getStackTrace();
        }

    }

    public void goToInventory() {
        try {

            goToInventory.click();
            Helper.implicitwait(driver);
        
        } catch (Exception exception) {
            exception.getStackTrace();
        }

    }


    public String getRefernceNo(){

        return refernceNo.getText();
    }
}
