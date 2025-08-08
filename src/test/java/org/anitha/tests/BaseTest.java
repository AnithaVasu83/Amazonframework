package org.anitha.tests;
import org.anitha.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import org.anitha.base.DriverFactory;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected ConfigLoader config;
    protected Logger logger;

    @BeforeClass(alwaysRun = true)
    public void setup() {

        logger=LogManager.getLogger(getClass());

        logger.info("===Test setup started for {} =====",getClass().getSimpleName());

        config = new ConfigLoader();

        String browserName = config.get("browser");

        WebDriver driver=null;
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        } else
        {
            logger.error("Brower not found: {} ",browserName);
            System.out.println("Browser not found");
        }












        DriverFactory.setDriver(driver);
        DriverFactory.getDriver().get(config.get("url"));
        System.out.println("URL = " + config.get("url"));

        logger.info("Browser {} started and navigated to URL {}...",browserName,config.get("url"));
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().manage().deleteAllCookies();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverFactory.getDriver().quit();
        DriverFactory.unload();
        logger.info("Browser closed and WebDriver unloaded for {}....",getClass().getSimpleName());
    }
}
