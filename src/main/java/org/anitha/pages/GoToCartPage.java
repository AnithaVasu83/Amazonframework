package org.anitha.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.anitha.base.DriverFactory;

public class GoToCartPage {

    private WebDriver driver;

    @FindBy(id = "proceedToRetailCheckout")
    private WebElement proceedBuy;

    public GoToCartPage() {
        this.driver = DriverFactory.getDriver(); // ThreadLocal-safe
        PageFactory.initElements(driver, this);
    }
    public String verifyCartPageTitle(){
        return driver.getTitle();
    }

    public CheckOut ProceedToBuy(){
        proceedBuy.click();
        return new CheckOut();

    }
}
