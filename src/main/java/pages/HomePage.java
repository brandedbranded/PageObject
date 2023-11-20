package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.editable;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

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

    public HomePage hoverClick(SelenideElement element) {
        element.shouldBe(visible, interactable).hover().shouldBe(visible, interactable).click();
        return this;
    }

    public HomePage sendKeysToInput(SelenideElement element, String query){
        element.shouldBe(visible, enabled).clear();
        element.shouldBe(visible, enabled, editable).sendKeys(query);
        return this;
    }
}