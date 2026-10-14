package FinalProject;

import Final_Project.HomePage;
import Final_Project.ProductPage;
import Final_Project.ResultSearchPage;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTitleTextTest extends BaseTest {

    @Test
    public void titleInSearchShouldMatchOnProduct() {
        testCaseId = 15;

        String productName = "Samsung";
        int productIndex = 3;

        HomePage homePage = new HomePage();
        homePage.writeOnSearchField(productName);
        homePage.clickOnButtonSearch();

        ResultSearchPage resultSearchPage = new ResultSearchPage();
        String actualTitleTextSearch = resultSearchPage.verifyTitleSearchResult();
        Assert.assertTrue(actualTitleTextSearch.contains(productName));
        SelenideElement product = resultSearchPage.getProduct(productIndex);
        String titleInSearch = product.getText();
        product.click();

        ProductPage productPage = new ProductPage();
        String titleOnProduct = productPage.verifyTitleProductName();
        Assert.assertEquals(titleOnProduct, titleInSearch);
    }
}
