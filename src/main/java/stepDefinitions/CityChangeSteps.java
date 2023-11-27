package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static assertForTests.Asserts.verifyRedirectToHomePage;
import static assertForTests.Asserts.verifyTextOnElement;
import static assertForTests.Steps.hoverClick;
import static assertForTests.Steps.sendKeysToInput;
import static com.codeborne.selenide.Condition.*;
import static common.Constants.WB_PAGE;
import static junit.framework.TestCase.assertEquals;
import static pages.AddressPage.*;
import static pages.HomePage.addressBtn;
import static pages.HomePage.visibleAddressOfChosenPoint;

public class CityChangeSteps {

    StringBuilder addressBuilder = new StringBuilder();

    @When("Нажимаем на кнопку смены города")
    public void clickChangeCityBtn() {
        hoverClick(addressBtn);
    }

    @And("Вводим {string} в поисковую строку")
    public void searchForCity(String arg0) {
        sendKeysToInput(searchBoxInAddress, arg0);
    }

    @And("Выбираем первый адрес из списка адресов {string}")
    public void selectFirstAddress(String arg0) {
        String address = firstFoundAddress.shouldBe(visible, enabled)
                .shouldHave(text(arg0)).getText();
        addressBuilder.append(address);
        firstFoundAddress.shouldBe(interactable).click();
        String address1 = aboutPointAddress.shouldBe(visible, enabled).getText();
        assertEquals(address1, address);
    }

    @And("Нажимаем кнопку {string}")
    public void clickSelectAddress(String arg0) {
        hoverClick(chooseAddressBtn);
    }

    @Then("Произошел переход на домашнюю страницу")
    public void verifyRedirectHomePage() {
        verifyRedirectToHomePage(WB_PAGE);
    }

    @And("На странице присутствует адрес выбранного пункта выдачи")
    public void addressContainsOnHomePage() {
        verifyTextOnElement(addressBuilder.toString(), visibleAddressOfChosenPoint);
    }
}
