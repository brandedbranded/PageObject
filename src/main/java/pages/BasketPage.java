package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BasketPage {

    public static SelenideElement priceInsideBasket = $x("//div[@class='list-item__price-new']");
    public static SelenideElement sumPriceInBasket = $("p.b-top__total span[data-jsv]");
    public static SelenideElement orderBtn = $x("//button[@data-link='{on submitOrder ~tag}']");
    public static SelenideElement nameInBasket = $x("//span[@class='good-info__good-name']");
}
