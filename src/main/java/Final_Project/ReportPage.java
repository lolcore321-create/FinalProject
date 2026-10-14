package Final_Project;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ReportPage {
    public void clickProblemTypeField() {
        $("[class='nesty-input']").click();
    }

    public void selectionOnTheProblem(String optionText) {
        $("#request_issue_type_select").selectOption(optionText);
    }

    public String emailField(String textToEmail) {
        $("[name='request[anonymous_requester_email]']").setValue(textToEmail);
        return textToEmail;
    }

    public String phoneNumber(String textNumber) {
        $("[type='number']").setValue(textNumber);
        return textNumber;
    }

    public void selectRequestTopicByKeyboard() {
        SelenideElement dropdown = $(("a.nesty-input"));
        dropdown.click();
        dropdown.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
        dropdown.sendKeys(Keys.ENTER);
    }

    public String writeTheTopic(String textTopic) {
        $("[aria-labelledby='request_subject_label']").setValue(textTopic);
        return textTopic;
    }

    public String writeDescription(String textDescription) {
        $("[name='request[description]']").setValue(textDescription);
        return textDescription;
    }

    public void clickToSend() {
        $("[type='submit']").click();
    }

    public String errorMessage() {
        return $("[id='request_anonymous_requester_email_error']").shouldBe(visible).getText();
    }
}
