package Final_Project;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ComparePage {
    public void clickOnListCompare() {
        $("[title='Смартфони та мобільні телефони']").click();
    }

    public void checkProductsCount(int expected) {
        $$("[class='VVEz- a0ov1']").shouldHave(size(expected));
    }

    public void clickOnMeatballsMenu() {
        $("[data-qaid='comparison_list_menu_btn']").click();
    }

    public void clickOnDeletedListCompare() {
        $("[class='k6I7C A2TgC']").click();
    }

    public void clickAcceptDeletedList() {
        $("[data-qaid='comparison_delete_confirm_btn']").click();
    }

    public String checkOnEmptyListCompare() {
        return $("[class*='la9uy _51RmA G']").shouldBe(visible).getText();
    }
}
