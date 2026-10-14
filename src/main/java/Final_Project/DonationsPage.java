package Final_Project;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DonationsPage {
    public String verifyTitlePageText() {
        return $("[class='eyMft2TORh29uC86IRml']").shouldBe(visible).getText();
    }


    public void checkDonateButtonDisabled() {
        SelenideElement closedCard = $$("[class='diDXRI1G1F_cNMRF6RsV']").findBy(text("Збір завершено"));
        closedCard.$("button").shouldBe(disabled);
    }

    public void clickOnAllCompanyDonate() {
        $("[class='v_yKtHX2fPdzMVaxNfWv']").click();
    }

    public String getCollected(int index) {
        return $$("[class*='fGp9EVyvDLH0lBTHbvo6']").get(index).getText().split("Ціль")[0];
    }

    public String getGoal(int index) {
        return $$("[class*='fGp9EVyvDLH0lBTHbvo6']").get(index).getText().split("Ціль")[1];
    }

    public String getPercent(int index) {
        return $$(".ant-progress-text").get(index).getText();
    }
}
