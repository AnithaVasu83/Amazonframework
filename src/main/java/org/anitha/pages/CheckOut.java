package org.anitha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import static org.anitha.tests.DriverFactory;

public class CheckOut {
    @FindBy(xpath="//*[@id='claim-collection-container']/h1")
    private WebElement sighIn;
    public CheckOut(){
        this.driver=DriverFactory.getDriver();
        PageFactory.initElements(driver,this);
    }

    public String checkedOut()
    {
        return sighIn.getText();

    }

}
