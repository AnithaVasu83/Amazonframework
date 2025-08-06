package org.anitha.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.anitha.tests.DriverFactory;

public class BaseTest {


    @BeforeMethod
    public void setup() {
        WebDriver driver = new ChromeDriver();
        DriverFactory.setDriver(driver);
        DriverFactory.getDRiver().get("")
        DriverFactory.getDriver().manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.getDriver().quit();
        DriverFactory.unload();
    }
}



