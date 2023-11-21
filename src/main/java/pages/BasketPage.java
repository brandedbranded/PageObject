package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.*;

public class BasketPage {

    public static SelenideElement priceInsideBasket = $x("//div[@class='list-item__price-new']");
    public static SelenideElement sumPriceInBasket = $("p.b-top__total span[data-jsv]");
    public static SelenideElement orderBtn = $x("//button[@data-link='{on submitOrder ~tag}']");
    public static SelenideElement nameInBasket = $x("//span[@class='good-info__good-name']");


    public BasketPage hoverClick(SelenideElement element) {
        element.shouldBe(visible, interactable).hover().shouldBe(visible, interactable).click();
        return this;
    }

    public BasketPage sendKeysToInput(SelenideElement element, String query) {
        element.shouldBe(visible, enabled).clear();
        element.shouldBe(visible, enabled, editable).sendKeys(query);
        return this;
    }
}
