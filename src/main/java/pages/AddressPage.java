package pages;

import static com.codeborne.selenide.Condition.editable;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;

public class AddressPage {

    public static SelenideElement searchBoxInAddress = $x(
        "//input[@class='ymaps-2-1-79-searchbox-input__input']");
    public static SelenideElement firstFoundAddress = $x(
        "(//span[@class='address-item__name-text'])[1]");
    public static SelenideElement aboutPointAddress = $x(
        "//span[@class='details-self__name-text']");
    public static SelenideElement chooseAddressBtn = $x(
        "//button[@class='details-self__btn btn-main']");

    public AddressPage hoverClick(SelenideElement element) {
        element.shouldBe(visible, interactable).hover().shouldBe(visible, interactable).click();
        return this;
    }

    public AddressPage sendKeysToInput(SelenideElement element, String query){
        element.shouldBe(visible, enabled).clear();
        element.shouldBe(visible, enabled, editable).sendKeys(query);
        return this;
    }

    public static String getAddressFromList(){
        String address = firstFoundAddress.shouldHave(text("Санкт-петербург")).getText();
        firstFoundAddress.click();
        return address;
    }
}
