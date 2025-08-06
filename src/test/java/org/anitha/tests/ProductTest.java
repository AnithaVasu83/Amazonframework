package org.anitha.tests;
import org.anitha.pages.ProductPage;
import org.anitha.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest{
    ProductPage productPage;
    SearchPage searchPage;
    @Test(priority=1)
    public void searchProduct(){
        searchPage = new SearchPage();
        productPage = searchPage.searchProduct("iphone");
    }
    @Test(priority=2)
    public void verifyPageTitleTest()
    {
        String expectedTitle= productPage.verifyPageTitle();
        Assert.assertTrue(expectedTitle,"Amazon.in : iphone");
    }
    @Test(priority=3)
    public void addToCartTest() {
        productPage.addToCart();
    }
    @Test(priority=4)
    public void clickIncrementIconTest(){
        productPage.clickIncrementIcon();

    }
}
