package Final_Project;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BuyersGuidePage {
    public String checkInTitlePage() {
        return $("[class='hero-title t36']").shouldBe(visible).getText();
    }


    public void clickOnSendRequest() {
        $("[class='submit-a-request']").click();
    }
}
