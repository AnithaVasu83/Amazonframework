package org.anitha.tests;

import org.anitha.pages.CheckOut;
import org.anitha.pages.GoToCartPage;
import org.anitha.pages.ProductPage;
import org.anitha.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CheckOutTest extends BaseTest{
    ProductPage productPage;
    SearchPage searchPage;
    GoToCartPage goToCartPage;
    CheckOut checkOut;

    @Test(priority=1)
    public void flowOfCheckOut(){
        searchPage = new SearchPage();
        productPage = searchPage.searchProduct("iphone");
        productPage.addToCart();
        productPage.clickIncrementIcon();
        goToCartPage=searchPage.goToCart();
        checkOut=goToCartPage.ProceedToBuy();

    }

    @Test(dependsOnMethods={"flowOfCheckOut"})
    public void checkOutTest()
    {
        String checkedOut=checkOut.checkedOut().trim();// use to trim extra space before and after
        Assert.assertEquals(checkedOut,"Sign in or create account");
    }

}
