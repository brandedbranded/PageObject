package pages;

import com.codeborne.selenide.SelenideElement;

import static assertForTests.Asserts.verifyQuantityOnPage;
import static assertForTests.Asserts.verifyTextOnElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static pages.ItemsAfterSearchPage.catalogTitle;
import static pages.ItemsAfterSearchPage.listOfFiltres;

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

    public FiltresAfterSearchPage verifyFilters() {
        verifyTextOnElement("Ноутбуки и ультрабуки", catalogTitle);
        verifyTextOnElement("до 3 дней", listOfFiltres);
        verifyTextOnElement("Apple", listOfFiltres);
        verifyTextOnElement("13", listOfFiltres);
        verifyTextOnElement("Сбросить все", listOfFiltres);
        verifyQuantityOnPage();
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
