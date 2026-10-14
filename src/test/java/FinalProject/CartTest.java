package FinalProject;

import Final_Project.CartPage;
import Final_Project.HomePage;
import Final_Project.ProductPage;
import Final_Project.ResultSearchPage;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    HomePage homePage = new HomePage();
    ResultSearchPage resultSearchPage = new ResultSearchPage();
    CartPage cartPage = new CartPage();
    ProductPage productPage = new ProductPage();

    @Test
    public void verifyAddToCart() {
        testCaseId = 3;

        String productName = "IPhone 18";
        int productIndex = 2;

        homePage.writeOnSearchField(productName);
        homePage.clickOnButtonSearch();

        SelenideElement product = resultSearchPage.getProduct(productIndex);
        product.click();

        String titleOnProduct = productPage.getProductTitle();
        String shortTitle = titleOnProduct.substring(0, titleOnProduct.indexOf("(")).trim();
        productPage.addToCart();
        productPage.checkCartCounter("1");
        productPage.clickOnCart();

        cartPage.checkProductTitleInCart(shortTitle);
    }

    @Test
    public void verifyProductRemovedFromCart() {
        testCaseId = 4;

        String productName = "Deye";
        int productIndex = 3;

        homePage.writeOnSearchField(productName);
        homePage.clickOnButtonSearch();

        SelenideElement product = resultSearchPage.getProduct(productIndex);
        product.click();

        productPage.addToCart();
        productPage.checkCartCounter("1");
        productPage.clickOnCart();

        cartPage.removeFirstProduct();
        String actualTitleText = cartPage.checkCartIsEmpty();
        Assert.assertTrue(actualTitleText.contains("Кошик порожній"));
        cartPage.clickToCloseCart();
        cartPage.checkCartCounterIsEmpty();
    }
}
