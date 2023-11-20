package pages;

import static com.codeborne.selenide.Condition.editable;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class ItemsAfterSearchPage {

    public static SelenideElement filterPath = $x("//ul[@class='breadcrumbs__list']");
    public static SelenideElement catalogTitle = $x("//h1[@class='catalog-title']");
    public static SelenideElement firstVacuum = $x("(//div[@class='product-card__wrapper'])[1]");
    public static SelenideElement addToBasket = $x(
        "//a[@class='product-card__add-basket j-add-to-basket btn-main-sm']");
    public static SelenideElement nameOfItem = $(".product-card__name");
    public static SelenideElement priceOfItem = $x("//ins[@class='price__lower-price']");
    public static SelenideElement allFiltres = $x(
        "//button[@class='dropdown-filter__btn dropdown-filter__btn--all']");
    public static SelenideElement listOfFiltres = $x("//ul[@class='your-choice__list']");
    public static SelenideElement titleAfterSearch = $x("//h1[@class='searching-results__title']");
    public static SelenideElement expectedAmountOfItems = $x(
        "//span[@data-link='html{spaceFormatted:pagerModel.totalItems}']");
    public static ElementsCollection amountOfItemsOnPage = $$(
        "a[class='product-card__link j-card-link j-open-full-product-card']");
    public static SelenideElement filterForItems = $(".dropdown-filter__btn--burger");
    public static SelenideElement sortBtn = $(".dropdown-filter__btn--sorter");
    public static SelenideElement brandOfFirstItem = $x(
        "(//span[@class='product-card__brand'])[1]");

    public ItemsAfterSearchPage hoverClick(SelenideElement element) {
        element.shouldBe(visible, interactable).hover().shouldBe(visible, interactable).click();
        return this;
    }

    public static String getNameOfItem() {
        return nameOfItem.shouldBe(visible, exist).getText().substring(2);
    }

    public static String getPriceOfItem() {
        return priceOfItem.shouldBe(visible, exist).getText();
    }

    public ItemsAfterSearchPage sendKeysToInput(SelenideElement element, String query){
        element.shouldBe(visible, enabled).clear();
        element.shouldBe(visible, enabled, editable).sendKeys(query);
        return this;
    }

    public ItemsAfterSearchPage hover(SelenideElement element) {
        element.shouldBe(visible, interactable).hover();
        return this;
    }

    public ItemsAfterSearchPage click(SelenideElement element) {
        element.shouldBe(visible, interactable).click();
        return this;
    }
}
