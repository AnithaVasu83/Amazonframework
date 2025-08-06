package org.anitha.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.anitha.tests.DriverFactory;

public class GoToCartPage {
    @FindBy(id = "proceedToRetailCheckout")
    private WebElement proceedBuy;
    public GoToCartPage() {
        this.driver = DriverFactory.getDriver(); // ThreadLocal-safe
        PageFactory.initElements(driver, this);
    }
    public String verifyCartPageTitle(){
        return DriverFactory.getDriver().getTitle();
    }

    public CheckOut ProceedToBuy(){
        proceedBuy.click();
        return new CheckOut();

    }
}
