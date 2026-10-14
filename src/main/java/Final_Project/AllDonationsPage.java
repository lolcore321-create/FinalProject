package Final_Project;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AllDonationsPage {
    public String verifyTitleTextPage() {
        return $("[class*='x__']").shouldBe(visible).getText();
    }

    public void checkCampaignsCountMoreThan(int count) {
        $$("[class*='BZY64wMe2J3HyVhzUHkb']").shouldHave(sizeGreaterThan(count));
    }
}
