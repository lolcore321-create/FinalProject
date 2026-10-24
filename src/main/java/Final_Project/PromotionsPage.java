package Final_Project;


import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PromotionsPage {
    public String checkInTitleText() {
        return $("[class*='la9uy a']").shouldBe(visible).getText();
    }

    public void selectPromotion(int promotionIndex) {
        $$("[class='_9xvHb VLiUF']").get(promotionIndex).click();
    }

    public void checkAllCardsHaveToPrice() {
        for (SelenideElement card : $$("ЛОКАТОР_КАРТОК").first(5)) {
            card.$("[data-qaid='old_price']").shouldBe(visible);
            card.$("[data-qaid='product_price']").shouldBe(visible);
        }
    }
}
