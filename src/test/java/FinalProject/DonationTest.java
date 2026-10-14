package FinalProject;

import Final_Project.AllDonationsPage;
import Final_Project.DonationsPage;
import Final_Project.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DonationTest extends BaseTest {
    HomePage homePage = new HomePage();
    DonationsPage donationsPage = new DonationsPage();

    @Test
    public void verifyDonateButtonDisabledWhenCampaignClosed() {
        testCaseId = 7;

        homePage.clickOnHelpTheDefenseForces();

        String actualTitleText = donationsPage.verifyTitlePageText();
        Assert.assertTrue(actualTitleText.contains("Підтримайте збори благодійних фондів"));
        donationsPage.checkDonateButtonDisabled();
    }

    @Test
    public void verifyAllCampaignsShowMoreThanThreeCards() {
        testCaseId = 8;

        homePage.clickOnHelpTheDefenseForces();

        donationsPage.clickOnAllCompanyDonate();

        AllDonationsPage allDonationsPage = new AllDonationsPage();
        String actualTitleTextPage = allDonationsPage.verifyTitleTextPage();
        Assert.assertTrue(actualTitleTextPage.contains("Оберіть збір"));
        allDonationsPage.checkCampaignsCountMoreThan(6);
    }

    @Test
    public void verifyPercentMatchesCollectedAndGoal() {
        testCaseId = 9;

        int card = 1;

        homePage.clickOnHelpTheDefenseForces();

        donationsPage.clickOnAllCompanyDonate();

        double collected = Double.parseDouble(donationsPage.getCollected(card).replaceAll("[^0-9]", ""));
        double goal = Double.parseDouble(donationsPage.getGoal(card).replaceAll("[^0-9]", ""));
        double percentOnCard = Double.parseDouble(donationsPage.getPercent(card).replaceAll("[^0-9]", ""));

        double expected = collected / goal * 100;

        Assert.assertTrue(Math.abs(expected - percentOnCard) <= 1,
                "Percent mismatch: calculated=" + expected + ", on card=" + percentOnCard);
    }
}
