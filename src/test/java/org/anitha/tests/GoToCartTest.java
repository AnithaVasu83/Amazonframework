package org.anitha.tests;
import org.anitha.pages.ProductPage;
import org.anitha.pages.SearchPage;
import org.anitha.pages.GoToCartPage;
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

    @Test(priority=2)
    public void titleTest(){
      String expectedResult=goToCartPage.verifyCartPageTitle();
    }

  @Test(priority=3)
    public void proceedingToBuy(){
      checkOut=goToCartPage.ProceedToBuy();

  }
}
