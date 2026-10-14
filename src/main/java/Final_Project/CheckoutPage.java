package Final_Project;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {
    public String getMonthlyPaymentOnCheckout() {
        return $("[data-testid='monthly_payment']").getText();
    }
}
