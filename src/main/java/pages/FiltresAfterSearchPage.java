package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.*;

public class FiltresAfterSearchPage {
    public static SelenideElement priceMin = $x("(//input[@class='j-price'])[1]");
    public static SelenideElement priceMax = $x("(//input[@class='j-price'])[2]");
    public static SelenideElement lessThan3DaysBtn = $x("//*[contains(text(), 'до 3 дней')]");
    public static SelenideElement brandApple = $x("//span[contains(text(), 'Apple')]");
    public static SelenideElement screen133 = $x("//span[contains(text(), '13.3')]");
    public static SelenideElement showItemsWithFiltres = $x(
        "//button[@class='filters-desktop__btn-main btn-main']");

    public FiltresAfterSearchPage choose(SelenideElement element) {
        element.shouldBe(visible, interactable).hover().shouldBe(visible, interactable).click();
        return this;
    }

    public FiltresAfterSearchPage sendKeysToInput(SelenideElement element, String query) {
        element.shouldBe(visible, enabled).clear();
        element.shouldBe(visible, enabled, editable, empty).sendKeys(query);
        return this;
    }

    public FiltresAfterSearchPage fillPriceFilter(String minPrice, String maxPrice) {
        priceMin.shouldBe(visible, enabled).clear();
        priceMax.shouldBe(visible, enabled).clear();
        priceMax.shouldBe(visible, enabled).clear();
        priceMin.shouldBe(visible, enabled, editable, empty).sendKeys(minPrice);
        priceMax.shouldBe(visible, enabled, editable, empty).sendKeys(maxPrice);
        return this;
    }
}
