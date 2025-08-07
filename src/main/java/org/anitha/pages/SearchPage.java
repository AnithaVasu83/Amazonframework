package org.anitha.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.anitha.base.DriverFactory;

public class SearchPage {

    private WebDriver driver;

    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private WebElement cart;

    @FindBy(id= "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id= "nav-search-submit-button")
    private WebElement searchBtn;

    public SearchPage() {
        this.driver = DriverFactory.getDriver(); // ThreadLocal-safe
        PageFactory.initElements(driver, this);
    }

    public ProductPage searchProduct(String keyword) {
        searchBox.sendKeys(keyword);
        searchBtn.click();
        return new ProductPage();
    }
    public GoToCartPage goToCart(){
        cart.click();
        return new GoToCartPage();

    }
}

