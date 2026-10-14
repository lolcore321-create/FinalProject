package FinalProject;

import Final_Project.GooglePlayPage;
import Final_Project.HomePage;
import Final_Project.ReviewsPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RatingComparisonTest extends BaseTest {
    @Test
    public void verifyPromRatingMatchesGooglePlay() {
        testCaseId = 14;

        HomePage homePage = new HomePage();
        homePage.clickOnReviews();

        ReviewsPage reviewsPage = new ReviewsPage();
        String actualTitlePageText = reviewsPage.checkTitlePage();
        Assert.assertTrue(actualTitlePageText.contains("Prom.ua відгуки"));
        String promRating = reviewsPage.getPromRating();
        reviewsPage.openGooglePlay();

        GooglePlayPage googlePlayPage = new GooglePlayPage();
        String playRating = googlePlayPage.getGooglePlayRating(); // "4.8"

        Assert.assertTrue(promRating.startsWith(playRating), "Ratings differ: Prom=" + promRating + ", Google Play=" + playRating);
    }
}
