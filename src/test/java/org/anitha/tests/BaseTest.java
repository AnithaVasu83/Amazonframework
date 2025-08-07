package org.anitha.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.anitha.tests.DriverFactory1;

public class BaseTest {


    @BeforeClass
    public void setup() {
        WebDriver driver = new ChromeDriver();
        DriverFactory1.setDriver(driver);
        DriverFactory1.getDriver().get("https://www.amazon.in/");
        DriverFactory1.getDriver().manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() {
        DriverFactory1.getDriver().quit();
        DriverFactory1.unload();
    }
}



