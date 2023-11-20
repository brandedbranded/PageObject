package pages;

import static com.codeborne.selenide.Condition.editable;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class BasketPage {
    public static SelenideElement priceInsideBasket = $x("//div[@class='list-item__price-new']");
    public static SelenideElement sumPriceInBasket = $("p.b-top__total span[data-jsv]");
    public static SelenideElement orderBtn = $x("//button[@data-link='{on submitOrder ~tag}']");

    public BasketPage hoverClick(SelenideElement element) {
        element.shouldBe(visible, interactable).hover().shouldBe(visible, interactable).click();
        return this;
    }

    public BasketPage sendKeysToInput(SelenideElement element, String query){
        element.shouldBe(visible, enabled).clear();
        element.shouldBe(visible, enabled, editable).sendKeys(query);
        return this;
    }
}
