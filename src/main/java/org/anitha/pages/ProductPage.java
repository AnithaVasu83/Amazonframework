package org.anitha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.anitha.base.DriverFactory;


public class ProductPage {

    private WebDriver driver;

    @FindBy(xpath="//*[@id='a-autoid-1-announce']")
    private WebElement addCart;

    public ProductPage(){
        this.driver=DriverFactory.getDriver();
        PageFactory.initElements(driver,this);

    }

    public String verifyPageTitle(){
       try {
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
           wait.until(ExpectedConditions.titleContains("Amazon.in : iphone"));
           return driver.getTitle();
       }catch(Exception e){
           throw new RuntimeException(e);
       }
    }

    public void addToCart(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(addCart)).click();
        }catch(Exception e)
        {
            throw new RuntimeException(e);
        }

    }

    public void clickIncrementIcon() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[data-a-selector=increment-icon]"))).click();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
