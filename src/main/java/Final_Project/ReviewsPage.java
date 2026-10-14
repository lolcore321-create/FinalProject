package Final_Project;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ReviewsPage {
    public String checkTitlePage() {
        return $("[data-qaid='app-reviews-title']").shouldBe(visible).getText();
    }

    public String getPromRating() {
        return $("[data-qaid='app-rating-android']").shouldBe(visible).getText().replace(",", ".");
    }

    public void openGooglePlay() {
        $("[data-qaid='app-install-android']").click();
    }
}
