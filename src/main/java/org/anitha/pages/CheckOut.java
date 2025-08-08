package org.anitha.pages;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.anitha.base.DriverFactory;
import org.apache.logging.log4j.Logger;




public class CheckOut {

    private WebDriver driver;
    private Logger logger= LogManager.getLogger(getClass());

    @FindBy(xpath="//h1[normalize-space()='Sign in or create account']") //use normalise-space() instead of text()
    private WebElement sighIn;

    public CheckOut(){
        this.driver=DriverFactory.getDriver();
        PageFactory.initElements(driver,this);
    }

    public String checkedOut()
    {
        String text=sighIn.getText();
        logger.info("Text is : {}",text);
        return text;

    }

}
