package org.anitha.tests;
import org.anitha.pages.ProductPage;
import org.anitha.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductPageTest extends BaseTest{
    ProductPage productPage;
    SearchPage searchPage;


 /* priority DOES NOT: Carry over test data, driver instance, page object state from one method to another.so use dependsOnMethods.
    also dont use more parameters in dependsonmethods.we can chain evrything in that specific test..so i wont depend on the other test.
    @Test
public void endToEndProductAddTest() {
  Login or navigate to search page if needed
    searchPage = new SearchPage();
  Step 1: Search product
    productPage = searchPage.searchProduct("iphone");
  Step 2: Verify title
    String actTitle = productPage.verifyPageTitle();
    Assert.assertEquals(actTitle, "Amazon.in : iphone");
  Step 3: Add to cart
    productPage.addToCart();
    Step 4: Click increment icon
    productPage.clickIncrementIcon();
    }

  */
    @Test(priority=1)
    public void verifyPageTitleTest()
    {
        searchPage = new SearchPage();
        productPage = searchPage.searchProduct("iphone");

        String actTitle= productPage.verifyPageTitle();
        System.out.println("Page Title: "+actTitle);
        Assert.assertEquals(actTitle,"Amazon.in : iphone");
    }

    @Test(dependsOnMethods={"verifyPageTitleTest"})
    public void addToCartTest() {
        productPage.addToCart();
    }

    @Test(dependsOnMethods={"addToCartTest"}) //here i use this method depends on addToCart instead of including both verifyPageTitle and addToCart
    public void clickIncrementIconTest(){
        productPage.clickIncrementIcon();

    }
}

