package com.aspire.components;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class TestBase {

    protected WebDriver driver;

    @BeforeTest
    public WebDriver setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://aspireapp.odoo.com");
        return driver;

    }

    @AfterTest
    public void teardown() {

        driver.close();
        driver.quit();

    }

}
