package org.anitha.tests;
import org.anitha.pages.ProductPage;
import org.anitha.pages.SearchPage;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    SearchPage searchPage;
    ProductPage productPage;

    @Test
    public void searchForProducts() {
        searchPage = new SearchPage();
        productPage = searchPage.searchProduct("iphone");

    }
}
