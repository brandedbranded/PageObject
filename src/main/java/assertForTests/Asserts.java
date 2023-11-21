package assertForTests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pages.ItemsAfterSearchPage.amountOfItemsOnPage;
import static pages.ItemsAfterSearchPage.expectedAmountOfItems;

public class Asserts {

    @Step("Проверка отображения текста: {expectedText} на элементе")
    public static void verifyTextOnElement(String expectedText, SelenideElement element) {
        assertTrue(element.shouldBe(visible, exist).getText().contains(expectedText));
    }

    @Step("Проверка соответствия цены товара ожидаемой цене")
    public static void verifyPriceOnElement(String expPrice, SelenideElement element) {
        element.shouldBe(visible, exist).shouldHave(text(expPrice));
        assertEquals(element.getText(), expPrice);
    }

    @Step("Проверка перехода на домашнюю страницу {url}")
    public static void verifyRedirectToHomePage(String url) {
        assertTrue(
                $x("//base[@href]").getAttribute("href").contains(url));
    }

    @Step("Проверка кликабельности элемента")
    public static void verifyClickable(SelenideElement element) {
        element.shouldBe(interactable);
    }

    @Step("Проверка соответствия количества товаров на странице с количеством, указанным после применения фильтров")
    public static void verifyQuantityOnPage() {
        amountOfItemsOnPage.shouldHave(size(Integer.parseInt(expectedAmountOfItems.getText())));
    }

    @Step("Проверка соответствия двух элементов")
    public static void verifyEquality(String s, String s1) {
        assertEquals(s, s1);
    }
}
