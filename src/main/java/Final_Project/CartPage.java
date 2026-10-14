package Final_Project;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    public void checkProductTitleInCart(String expected) {
        $("[class='_0IAAW jnbX-']").shouldHave(text(expected));
    }

    public void removeFirstProduct() {
        $("[data-testid='remove_btn']").click();
    }

    public String checkCartIsEmpty() {
        return $("[data-testid='title_text']").shouldBe(visible).getText();
    }

    public void clickToCloseCart() {
        $("[aria-label='Закрити']").click();
    }

    public void checkCartCounterIsEmpty() {
        $("[data-qaid='counter']").shouldNot(exist);
    }
}


