package FinalProject;

import Final_Project.HomePage;
import Final_Project.ResultSearchPage;
import org.testng.annotations.Test;

public class SellerSearchTest extends BaseTest {
    @Test
    public void verifyFindSellerWithTwoProducts() {
        testCaseId = 16;

        String productName1 = "IPhone 18";
        String productName2 = "Чехол";
        int first = 0;
        int second = 1;

        HomePage homePage = new HomePage();
        homePage.clickOnSearchField();
        homePage.clickFindAllFromOneSeller();
        homePage.fillProduct(first, productName1);
        homePage.fillProduct(second, productName2);
        homePage.checkShowSellersButtonEnabled();
        homePage.clickShowSellers();

        ResultSearchPage resultSearchPage = new ResultSearchPage();
        resultSearchPage.checkSellersListNotEmpty();
    }
}
