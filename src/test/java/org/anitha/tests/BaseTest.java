package org.anitha.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import org.anitha.base.DriverFactory;

public class BaseTest {


    @BeforeClass
    public void setup() {
        WebDriver driver = new ChromeDriver();
        DriverFactory.setDriver(driver);
        DriverFactory.getDriver().get("https://www.amazon.in/");
        DriverFactory.getDriver().manage().window().maximize();

    }

    @AfterClass
    public void tearDown() {
        DriverFactory.getDriver().quit();
        DriverFactory.unload();
    }
}
