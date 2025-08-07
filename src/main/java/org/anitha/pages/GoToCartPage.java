package org.anitha.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.anitha.base.DriverFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoToCartPage {

    private WebDriver driver;

    @FindBy(name = "proceedToRetailCheckout")
    private WebElement proceedBuy;

    public GoToCartPage() {
        this.driver = DriverFactory.getDriver(); // ThreadLocal-safe
        PageFactory.initElements(driver, this);
    }
    public String verifyCartPageTitle() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains("Amazon.in Shopping Cart"));
            return driver.getTitle();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public CheckOut ProceedToBuy(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(proceedBuy)).click();
            return new CheckOut();
        }catch(Exception e) {
            throw new RuntimeException(e);
        }

    }
}
