package Final_Project;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductPage {
    public String verifyTitleProductName() {
        return $("[data-qaid='product_name']").shouldBe(visible).getText();
    }

    public void addToCart() {
        $("[class*='I80Um DuFM2 vFL5E R64la z']").click();
    }

    public void checkCartCounter(String expected) {
        $("[data-qaid='counter']").shouldHave(text(expected));
    }

    public void clickOnCart() {
        $("[data-qaid='shopping_cart']").click();
    }

    public String getProductTitle() {
        return $("[data-qaid='product_name']").getText();
    }

    public void clickOnPaymentInInstallments() {
        $("[data-qaid='pay_parts_btn']").click();
    }

    public String getSelectedBankPayment() {
        return $$("[data-testid='monthly_payment']").last().getText();
    }

    public void selectBank(int index) {
        $$("[class='D6oc6 YieAW']").get(index).click();
    }

    public void clickOnContinue() {
        $("[data-testid='go_on_btn']").click();
    }

}
