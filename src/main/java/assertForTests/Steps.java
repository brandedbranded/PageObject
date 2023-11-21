package assertForTests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static pages.BasketPage.nameInBasket;

public class Steps {

    @Step("Наведение курсора на элемент и нажатие на элемент")
    public static void hoverClick(SelenideElement element) {
        element
                .shouldBe(visible, enabled)
                .hover()
                .shouldBe(interactable)
                .click();
    }

    public static void hover(SelenideElement element) {
        element
                .shouldBe(visible, enabled)
                .hover();
    }

    public static void sendKeysToInput(SelenideElement element, String query) {
        element
                .shouldBe(visible)
                .clear();
        element
                .shouldBe(editable)
                .sendKeys(query + Keys.ENTER);
    }

    public static String getNameInBasket() {
        return nameInBasket
                .shouldBe(visible)
                .getText().replace("/", "")
                .replace(" ", "");
    }
}
