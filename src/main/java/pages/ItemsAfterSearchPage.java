package pages;

import static assertForTests.Steps.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static pages.HomePage.*;

import com.codeborne.selenide.*;

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

    public static String getNameOfItem() {
        return nameOfItem.shouldBe(visible, exist).getText().replace("/", "").replace(" ", "");
    }

    public static String getPriceOfItem() {
        return priceOfItem.shouldBe(visible, exist).getText();
    }


    public ItemsAfterSearchPage chooseFirstVacuum() {
        firstVacuum.shouldBe(enabled, visible).hover();
        hoverClick(addToBasket);
        return this;
    }

    public ItemsAfterSearchPage clearSearchLineWithCross() {
        crossBtn.shouldBe(visible, interactable).hover().shouldBe(visible, interactable).click();
        return new ItemsAfterSearchPage();
    }

    public FiltresAfterSearchPage openFilters() {
        hoverClick(allFiltres);
        return new FiltresAfterSearchPage();
    }
}
