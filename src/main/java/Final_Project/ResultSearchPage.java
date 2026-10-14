package Final_Project;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ResultSearchPage {
    private static final String COMPARE_ICON = "[title='Порівняння']";

    public String verifyTitleSearchResult() {
        return $("[class*='la9uy _5']").shouldBe(visible).getText();
    }

    public SelenideElement getProduct(int productIndex) {
        return $$("[class*='se07P aV5Sw K']").get(productIndex);
    }

    public void selectCategory(String name) {
        $("a[title*='" + name + "']").click();
    }

    public void addToCompare(int index) {
        $$("[data-qaid='add_compare']").get(index).click();
    }

    public void checkCompareCounter(String expected) {
        $(COMPARE_ICON).shouldHave(text(expected));
    }

    public void clickCompareIcon() {
        $(COMPARE_ICON).click();
    }

    public void clickOnThePriceLowFilter() {
        $x("//span[text()='Дешевше']").click();
    }

    public void clickOnThePriceHighFilter() {
        $x("//span[text()='Дорожче']").click();
    }

    public List<Double> getPrices(int count) {
        $$("[data-qaid='product_price']").shouldHave(sizeGreaterThan(0));
        List<Double> prices = new ArrayList<>();
        for (SelenideElement price : $$("[data-qaid='product_price']").first(count)) {
            prices.add(Double.parseDouble(price.getText().replaceAll("[^0-9.]", "")));
        }
        return prices;
    }

    public void setPriceFrom(String value) {
        $("[data-qaid='price_local__gte'] input").setValue(value);
    }

    public void setPriceTo(String value) {
        $("[data-qaid='price_local__lte'] input").setValue(value);
    }

    public void clickApplyPrice() {
        $("[data-qaid='accept_price']").click();
    }

    public void checkSellersListNotEmpty() {
        $$("[class='CYbEu GbYMt Y8Atp']").shouldHave(CollectionCondition.sizeGreaterThan(0));
    }
}
