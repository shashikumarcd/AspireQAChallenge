package com.aspire.helper;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

    protected WebDriverWait wait;

    public boolean elementPresent(WebElement locator, WebDriver driver) throws Exception {

        boolean isDisplayed = locator.isDisplayed();

        return isDisplayed;
    }

    public static void implicitwait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void explicitwait(WebElement element, WebDriver driver) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeSelected(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public static void selectDropDownOption(WebDriver driver, String product, WebElement selectOption,
            List<WebElement> totalLists) {
        try {            
            selectOption.click();
            selectOption.sendKeys(product);

            for(int i=1;i<totalLists.size();i++){

                WebElement element = driver.findElement(By.xpath("//*[@id='ui-id-1']/li["+i+"]/a"));
                if (element.getText().contains(product)) {
                    element.click();
                    break;
                }
            }
        } catch (StaleElementReferenceException exception) {
            List<WebElement> list = totalLists;
            for (WebElement element : list) {
                if (element.getText().contains(product))
                    continue;
                element.click();
                break;
            }

        }

    }

    public static WebElement elementIsVisible(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement elementToBeClickable(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void moveToElement(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }
}
