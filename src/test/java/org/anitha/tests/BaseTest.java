package org.anitha.tests;
import org.anitha.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import org.anitha.base.DriverFactory;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public ConfigLoader config;


    @BeforeClass
    public void setup() {

        config = new ConfigLoader();
        String browsername = config.get("browser");

        WebDriver driver=null;
        if (browsername.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browsername.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browsername.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        } else System.out.println("Browser ot found");


        DriverFactory.setDriver(driver);
        DriverFactory.getDriver().get(config.get("url"));
        System.out.println("URL = " + config.get("url"));
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().manage().deleteAllCookies();

    }

    @AfterClass
    public void tearDown() {
        DriverFactory.getDriver().quit();
        DriverFactory.unload();
    }
}
