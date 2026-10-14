package FinalProject;

import Final_Project.BuyersGuidePage;
import Final_Project.HomePage;
import Final_Project.ReportPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HelpRequestTest extends BaseTest {
    @Test
    public void verifyRequestIsSent() {
        testCaseId = 10;

        String email = "avadakedavra";
        String numberPhone = "42142525";
        String topic = "Subject of the situation";
        String description = "Here, I describe the situation in detail";


        HomePage homePage = new HomePage();
        homePage.clickOnBuyerHelp();

        BuyersGuidePage buyersGuidePage = new BuyersGuidePage();
        String actualTitleTextPage = buyersGuidePage.checkInTitlePage();
        Assert.assertTrue(actualTitleTextPage.contains("Чим ми можемо допомогти"));
        buyersGuidePage.clickOnSendRequest();

        ReportPage reportPage = new ReportPage();
        reportPage.clickProblemTypeField();
        reportPage.selectionOnTheProblem("Кабінет покупця");
        reportPage.emailField(email);
        reportPage.phoneNumber(numberPhone);
        reportPage.selectRequestTopicByKeyboard();
        reportPage.writeTheTopic(topic);
        reportPage.writeDescription(description);
        reportPage.clickToSend();
        reportPage.errorMessage();
    }
}
