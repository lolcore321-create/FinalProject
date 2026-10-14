package FinalProject;

import Final_Project.ComparePage;
import Final_Project.HomePage;
import Final_Project.ResultSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareProductsTest extends BaseTest {
    String productName = "IPhone 18";
    HomePage homePage = new HomePage();
    ResultSearchPage resultSearchPage = new ResultSearchPage();
    ComparePage comparePage = new ComparePage();

    @Test
    public void verifyTwoProductsInCompareButTheirDifference() {
        testCaseId = 5;

        homePage.writeOnSearchField(productName);
        homePage.clickOnButtonSearch();

        resultSearchPage.selectCategory("Смартфони та мобільні");
        resultSearchPage.addToCompare(1);
        resultSearchPage.addToCompare(3);
        resultSearchPage.checkCompareCounter("2");
        resultSearchPage.clickCompareIcon();

        comparePage.clickOnListCompare();
        comparePage.checkProductsCount(2);
    }

    @Test
    public void verifyCompareListIsEmptyAfterClear() {
        testCaseId = 6;

        homePage.writeOnSearchField(productName);
        homePage.clickOnButtonSearch();

        resultSearchPage.selectCategory("Смартфони та мобільні");
        resultSearchPage.addToCompare(0);
        resultSearchPage.addToCompare(1);
        resultSearchPage.checkCompareCounter("2");
        resultSearchPage.clickCompareIcon();

        comparePage.clickOnMeatballsMenu();
        comparePage.clickOnDeletedListCompare();
        comparePage.clickAcceptDeletedList();
        String actualPageTitleText = comparePage.checkOnEmptyListCompare();
        Assert.assertTrue(actualPageTitleText.contains("Немає товарів для порівняння"));
    }
}
