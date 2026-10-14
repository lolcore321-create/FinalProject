package FinalProject;

import Final_Project.HomePage;
import Final_Project.PromotionsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PromotionsDiscountTest extends BaseTest {
    @Test
    public void verifyProductsHaveDiscount() {
        testCaseId = 13;

        HomePage homePage = new HomePage();
        homePage.openPromotions();

        PromotionsPage promotionsPage = new PromotionsPage();
        String actualTextPromotionsPage = promotionsPage.checkInTitleText();
        Assert.assertTrue(actualTextPromotionsPage.contains("Акції від продавців"));
        promotionsPage.selectPromotion(2);
        promotionsPage.checkAllCardsHaveToPrice();
    }
}
