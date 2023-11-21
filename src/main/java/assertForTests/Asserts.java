package assertForTests;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;
import static pages.ItemsAfterSearchPage.*;

import com.codeborne.selenide.*;

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

    public static void verifyQuantityOnPage() {
        amountOfItemsOnPage.shouldHave(size(Integer.parseInt(expectedAmountOfItems.getText())));
    }

    public static void verifyEquality(String s, String s1) {
        assertEquals(s, s1);
    }
}
