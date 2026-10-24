package Final_Project;


import com.codeborne.selenide.Selenide;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private static final String SEARCH_FIELD = "[type='search']";


    public String writeOnSearchField(String textToSearch) {
        $(SEARCH_FIELD).setValue(textToSearch);
        return textToSearch;
    }

    public void clickOnButtonSearch() {
        $("[type='submit']").click();
    }

    public void openPromotions() {
        $("[href='/ua/season_sales']").click();
    }

    public void clickOnBuyerHelp() {
        $("[href='https://help.prom.ua/hc/uk']").click();
        ArrayList<String> tabs = new ArrayList<>(Selenide.webdriver().driver().getWebDriver().getWindowHandles());
        switchTo().window(tabs.get(tabs.size() - 1));
    }

    public void clickOnReviews() {
        $("[href='/ua/reviews']").click();
    }

    public void clickOnHelpTheDefenseForces() {
        $("[href='https://volonter.prom.ua/']").click();
        switchTo().window(1);
    }

    public void clickOnSearchField() {
        $(SEARCH_FIELD).click();
    }

    public void clickFindAllFromOneSeller() {
        $("[class='I80Um xP4B1']").click();
    }


    public void fillProduct(int index, String name) {
        $$("[data-qaid='multi_search_term'] input").get(index).setValue(name);
    }

    public void checkShowSellersButtonEnabled() {
        $("[data-qaid='search_companies']").shouldBe(enabled);
    }

    public void clickShowSellers() {
        $("[data-qaid='search_companies']").click();
    }
}
