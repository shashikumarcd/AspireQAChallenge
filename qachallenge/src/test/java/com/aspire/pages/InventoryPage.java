package com.aspire.pages;

import java.util.ArrayList;
import java.util.List;

import com.aspire.helper.Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[@class='o_menu_sections']/li[3]/a")
    private WebElement productsMenu;

    @FindBy(how = How.XPATH, using = "//*[@class='o_menu_sections']/li[3]/div/a")
    private WebElement productsMenuOption;

    @FindBy(how = How.XPATH, using = "//span[text()='Manufacturing']")
    private WebElement manufacturingOption;

    @FindBy(how = How.CLASS_NAME, using = "o_searchview_input")
    private WebElement searchInput;

    @FindBy(how = How.XPATH, using = "//*[@class='btn-group o_search_options position-static']/div[1]/button")
    private WebElement filterButton;

    @FindBy(how = How.XPATH, using = "//*[@class='o_dropdown_menu dropdown-menu show']/list")
    private List<WebElement> filterOptions;

    @FindBy(how = How.XPATH, using = "//*[@class='table-responsive']/table/tbody/tr")
    private List<WebElement> totalRows;

    public void gotoProducts() throws InterruptedException {

        try {

            Helper.elementIsVisible(driver, productsMenu);
            productsMenu.click();

            Helper.elementToBeClickable(driver, productsMenuOption);
            productsMenuOption.click();
            Helper.implicitwait(driver);

        } catch (Exception exception) {
            exception.getStackTrace();
        }

    }

    public void gotoManufacturing() throws InterruptedException {

        try {

            Helper.elementIsVisible(driver, manufacturingOption);
            manufacturingOption.click();

            Helper.implicitwait(driver);

        } catch (Exception exception) {
            exception.getStackTrace();
        }

    }

    public void selectDoneFilterOption() throws InterruptedException {

        // selecting filter option Done
        filterButton.click();

        try {             
        for (int i = 1; i < filterOptions.size(); i++) {
            WebElement element = driver
                    .findElement(By.xpath("//*[@class='o_dropdown_menu dropdown-menu show']/**list[i]**/a"));
            if (element.getText() == "Done") {
                element.click();
            }
        }
        //getting referneno
        // for (int i = 1; i < totalRows.size(); i++) {

        //     WebElement element = driver
        //             .findElement(By.xpath("//*[@class='table-responsive']/table/tbody/**tr[i]**/td[3]"));
        //     if (element.getText() == referenceNo) {
        //         referenceNo = element.getText();
        //     }
        // }

        } catch (Exception exception) {
            exception.getStackTrace();
        }
    }

    public List<String> refernceList(){

        List<String> referenceList =new ArrayList<String>();
        for (int i = 1; i < totalRows.size(); i++) {

            WebElement element = driver.findElement(By.xpath("//*[@class='table-responsive']/table/tbody/tr["+i+"]/td[3]"));
            referenceList.add(element.getText());           
        }

        return referenceList;
    }
}
