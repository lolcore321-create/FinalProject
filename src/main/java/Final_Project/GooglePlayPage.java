package Final_Project;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GooglePlayPage {
    public String getGooglePlayRating() {
        return $("[class='jILTFe']").shouldBe(visible).getText().replace(",", ".");
    }
}
