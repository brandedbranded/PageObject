package pages;

import com.codeborne.selenide.SelenideElement;

import static assertForTests.Asserts.verifyRedirectToHomePage;
import static assertForTests.Asserts.verifyTextOnElement;
import static assertForTests.Steps.hoverClick;
import static assertForTests.Steps.sendKeysToInput;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static common.Constants.WB_PAGE;
import static pages.HomePage.visibleAddressOfChosenPoint;

public class AddressPage {

    public static SelenideElement searchBoxInAddress = $x(
        "//input[@class='ymaps-2-1-79-searchbox-input__input']");
    public static SelenideElement firstFoundAddress = $x(
        "(//span[@class='address-item__name-text'])[1]");
    public static SelenideElement aboutPointAddress = $x(
        "//span[@class='details-self__name-text']");
    public static SelenideElement chooseAddressBtn = $x(
        "//button[@class='details-self__btn btn-main']");


    public AddressPage inputCityName(String query) {
        sendKeysToInput(searchBoxInAddress, query);
        return this;
    }

    public AddressPage openFirstAddress(StringBuilder builder) {
        String address = firstFoundAddress.shouldBe(visible, enabled)
            .shouldHave(text("Санкт-петербург")).getText();
        firstFoundAddress.shouldBe(interactable).click();
        builder.append(address);
        return this;
    }

    public AddressPage chooseFirstAddress(StringBuilder builder) {
        String address = aboutPointAddress.shouldBe(visible, enabled).getText();
        builder.append(address);
        hoverClick(chooseAddressBtn);
        verifyTextOnElement(address.toString(), visibleAddressOfChosenPoint);
        verifyRedirectToHomePage(WB_PAGE);
        return this;
    }
}
