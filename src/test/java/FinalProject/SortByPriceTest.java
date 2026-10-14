package FinalProject;

import Final_Project.HomePage;
import Final_Project.ResultSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SortByPriceTest extends BaseTest {
    @Test
    public void verifyPricesSortedDescendingAndAscending() {
        testCaseId = 17;

        String productName = "3d printer";

        HomePage homePage = new HomePage();
        homePage.writeOnSearchField(productName);
        homePage.clickOnButtonSearch();

        ResultSearchPage resultSearchPage = new ResultSearchPage();
        resultSearchPage.clickOnThePriceHighFilter();
        List<Double> expensive = resultSearchPage.getPrices(5);
        for (int i = 0; i < expensive.size() - 1; i++) {
            Assert.assertTrue(expensive.get(i) >= expensive.get(i + 1), "Prices not in descending order: " + expensive);
        }

        resultSearchPage.clickOnThePriceLowFilter();
        List<Double> cheap = resultSearchPage.getPrices(5);
        for (int i = 0; i < cheap.size() - 1; i++) {
            Assert.assertTrue(cheap.get(i) <= cheap.get(i + 1), "Prices not in ascending order: " + cheap);
        }
    }
}
