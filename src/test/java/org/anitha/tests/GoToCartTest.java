package org.anitha.tests;
import org.anitha.pages.ProductPage;
import org.anitha.pages.SearchPage;
import org.anitha.pages.GoToCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.anitha.pages.CheckOut;

public class GoToCartTest extends BaseTest{
    ProductPage productPage;
    SearchPage searchPage;
    GoToCartPage goToCartPage;
    CheckOut checkOut;

    @Test(priority=1)
    public void goToCartTest(){
        searchPage = new SearchPage();
        productPage = searchPage.searchProduct("iphone");
        productPage.addToCart();
        productPage.clickIncrementIcon();
        goToCartPage=searchPage.goToCart();
    }

    @Test(dependsOnMethods={"goToCartTest"})
    public void titleTest(){

        String actTitleResult=goToCartPage.verifyCartPageTitle();
        System.out.println("Page Title: "+actTitleResult);
        Assert.assertEquals(actTitleResult,"Amazon.in Shopping Cart");
    }

  @Test(dependsOnMethods={"titleTest"})
    public void proceedingToBuy(){
      checkOut=goToCartPage.ProceedToBuy();

  }
}
