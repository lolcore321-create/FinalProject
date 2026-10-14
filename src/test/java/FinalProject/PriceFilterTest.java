package FinalProject;

import Final_Project.HomePage;
import Final_Project.ResultSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PriceFilterTest extends BaseTest {
    @Test
    public void verifyPricesWithinSelectedRange() {
        testCaseId = 12;

        String productName = "Генератор";
        int minPrice = 20000;
        int maxPrice = 50000;

        HomePage homePage = new HomePage();
        homePage.writeOnSearchField(productName);
        homePage.clickOnButtonSearch();

        ResultSearchPage resultSearchPage = new ResultSearchPage();
        resultSearchPage.setPriceFrom(String.valueOf(minPrice));
        resultSearchPage.setPriceTo(String.valueOf(maxPrice));
        resultSearchPage.clickApplyPrice();

        List<Double> prices = resultSearchPage.getPrices(5);
        Assert.assertFalse(prices.isEmpty(), "No products found after applying price filter");
        for (double price : prices) {
            Assert.assertTrue(price >= minPrice && price <= maxPrice, "Price is outside the range " + minPrice + "-" + maxPrice + ": " + prices);
        }
    }
}
