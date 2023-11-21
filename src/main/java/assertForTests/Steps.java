package assertForTests;

import static com.codeborne.selenide.Condition.*;
import static pages.BasketPage.*;

import com.codeborne.selenide.*;
import org.openqa.selenium.*;

public class Steps {

    public static void hoverClick(SelenideElement element) {
        element.shouldBe(visible, enabled).hover().shouldBe(interactable).click();
    }

    public static void hover(SelenideElement element) {
        element.shouldBe(visible, enabled).hover();
    }

    public static void sendKeysToInput(SelenideElement element, String query) {
        element.shouldBe(visible).clear();
        element.shouldBe(editable).sendKeys(query + Keys.ENTER);
    }

    public static String getNameInBasket() {
        return nameInBasket.shouldBe(visible).getText().replace("/", "").replace(" ", "");
    }
}
