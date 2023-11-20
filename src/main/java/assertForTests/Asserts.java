package assertForTests;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pages.ItemsAfterSearchPage.amountOfItemsOnPage;
import static pages.ItemsAfterSearchPage.expectedAmountOfItems;

import com.codeborne.selenide.SelenideElement;

public class Asserts {

    public static void checkTextContainsOnPage(String expectedText) {
        $x("//body").shouldHave(text(expectedText));
    }

    public static void verifyTextOnElement(String expectedText, SelenideElement element) {
        assertTrue(element.shouldBe(visible, exist).getText().contains(expectedText));
    }

    public static void verifyPriceOnElement(String expPrice, SelenideElement element) {
        element.shouldBe(visible, exist).shouldHave(text(expPrice));
        assertEquals(element.getText(), expPrice);
    }

    public static void verifyRedirectToHomePage(String url) {
        assertTrue(
            $x("//base[@href]").getAttribute("href").contains(url));
    }

    public static void verifyClickable(SelenideElement element) {
        element.shouldBe(interactable);
    }

    public static void verifyQuantityOnPage(){
        amountOfItemsOnPage.shouldHave(size(Integer.parseInt(expectedAmountOfItems.getText())));
    }
}
