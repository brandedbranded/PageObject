package pages;

import static com.codeborne.selenide.Condition.editable;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class FilterHomePage {

    public static SelenideElement electronicsBtn = $x("//li[@data-menu-id='4830']");
    public static SelenideElement laptopsAndPc = $x(
        "//span[contains(text(), 'Ноутбуки и компьютеры')]");
    public static SelenideElement laptops = $(By.linkText("Ноутбуки"));
    public static SelenideElement householdBtn = $x("//li[@data-menu-id='16107']");
    public static SelenideElement homeAppliancesBtn = $x(
        "//span[contains(text(), 'Техника для дома')]");
    public static SelenideElement vacuums = $(By.linkText("Пылесосы и пароочистители"));

    public FilterHomePage hoverClick(SelenideElement element) {
        element.shouldBe(visible, interactable).hover().shouldBe(visible, interactable).click();
        return this;
    }

    public FilterHomePage hover(SelenideElement element) {
        element.shouldBe(visible, interactable).hover();
        return this;
    }

    public FilterHomePage click(SelenideElement element) {
        element.shouldBe(visible, interactable).click();
        return this;
    }

    public FilterHomePage sendKeysToInput(SelenideElement element, String query) {
        element.shouldBe(visible, enabled).clear();
        element.shouldBe(visible, enabled, editable).sendKeys(query);
        return this;
    }
}
