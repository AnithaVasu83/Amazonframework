package org.anitha.tests;

import org.anitha.pages.CheckOut;
import org.anitha.pages.GoToCartPage;
import org.anitha.pages.ProductPage;
import org.anitha.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.anitha.base.BaseTest;



public class CheckOutTest extends BaseTest{
    ProductPage productPage;
    SearchPage searchPage;
    GoToCartPage goToCartPage;
    CheckOut checkOut;

    @Test(priority=1)
    public void flowOfcheckOut(){
        searchPage = new SearchPage();
        productPage = searchPage.searchProduct("iphone");
        productPage.addToCart();
        productPage.clickIncrementIcon();
        goToCartPage=searchPage.goToCart();
        checkOut=goToCartPage.ProceedToBuy();

    }

    @Test(priority=2)
    public void checkOutTest()
    {
        String checkedOut=checkOut.checkedOut();
        Assert.assertEquals(checkedOut,"Sign in or create account");
    }

}
