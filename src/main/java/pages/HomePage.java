package pages;

import com.codeborne.selenide.SelenideElement;

import static assertForTests.Asserts.*;
import static assertForTests.Steps.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static pages.BasketPage.*;

// page_url = https://www.wildberries.ru/
public class HomePage {

    public static SelenideElement searchLine = $("input[id='searchInput']");
    public static SelenideElement basketBtn = $x(
        "//span[@class='navbar-pc__icon navbar-pc__icon--basket']");
    public static SelenideElement counterAboveBasket = $x("//span[@class='navbar-pc__notify']");
    public static SelenideElement filterBtn = $x("//span[@class='nav-element__burger-line']");
    public static SelenideElement addressBtn = $x("//span[@data-wba-header-name='DLV_Adress']");
    public static SelenideElement visibleAddressOfChosenPoint = $x(
        "//span[@class='simple-menu__link simple-menu__link--address j-geocity-link j-wba-header-item']");
    public static SelenideElement crossBtn = $x(
        "//button[@class='search-catalog__btn search-catalog__btn--clear search-catalog__btn--active']");


    public ItemsAfterSearchPage searchItem(String query) {
        sendKeysToInput(searchLine, query);
        return new ItemsAfterSearchPage();
    }

    public AddressPage openAddress() {
        hoverClick(addressBtn);
        return new AddressPage();
    }

    public FilterHomePage openFilters() {
        hoverClick(filterBtn);
        return new FilterHomePage();
    }

    public HomePage goToCart(String name, String price) {
        hoverClick(basketBtn);
        verifyPriceOnElement(price, priceInsideBasket);
        verifyEquality(name, getNameInBasket());
        verifyPriceOnElement(price, sumPriceInBasket);
        verifyClickable(orderBtn);
        return this;
    }
}