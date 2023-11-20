package pages;

import static com.codeborne.selenide.Condition.editable;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class FiltresAfterSearchPage {
    public static SelenideElement priceMin = $x("(//input[@class='j-price'])[1]");
    public static SelenideElement priceMax = $x("(//input[@class='j-price'])[2]");
    public static SelenideElement lessThan3DaysBtn = $x("//*[contains(text(), 'до 3 дней')]");
    public static SelenideElement brandApple = $x("//span[contains(text(), 'Apple')]");
    public static SelenideElement screen133 = $x("//span[contains(text(), '13.3')]");
    public static SelenideElement showItemsWithFiltres = $x(
        "//button[@class='filters-desktop__btn-main btn-main']");

    public FiltresAfterSearchPage hoverClick(SelenideElement element) {
        element.shouldBe(visible, interactable).hover().shouldBe(visible, interactable).click();
        return this;
    }

    public FiltresAfterSearchPage sendKeysToInput(SelenideElement element, String query){
        element.shouldBe(visible, enabled).clear();
        element.shouldBe(visible, enabled, editable).sendKeys(query);
        return this;
    }
}
