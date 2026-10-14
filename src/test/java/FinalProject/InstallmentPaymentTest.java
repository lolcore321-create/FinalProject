package FinalProject;

import Final_Project.CheckoutPage;
import Final_Project.HomePage;
import Final_Project.ProductPage;
import Final_Project.ResultSearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class InstallmentPaymentTest extends BaseTest {
    @Test
    public void verifyMonthlyPaymentMatchesSelectedBank() {
        testCaseId = 11;

        String productName = "IPhone 18";

        HomePage homePage = new HomePage();
        homePage.writeOnSearchField(productName);
        homePage.clickOnButtonSearch();

        ResultSearchPage resultSearchPage = new ResultSearchPage();
        resultSearchPage.selectCategory("Смартфони та мобільні");
        resultSearchPage.getProduct(1).click();

        ProductPage productPage = new ProductPage();
        productPage.clickOnPaymentInInstallments();
        productPage.selectBank(1);
        String panelAmount = productPage.getSelectedBankPayment().replaceAll("[^0-9.]", "");  // 19499.75
        productPage.clickOnContinue();

        CheckoutPage checkoutPage = new CheckoutPage();
        String checkoutAmount = checkoutPage.getMonthlyPaymentOnCheckout().replaceAll("[^0-9.]", "");


        Assert.assertEquals(checkoutAmount, panelAmount);


    }
}
