package stepdefinitions;

import io.cucumber.java.en.*;
import pages.*;

import static assertForTests.Asserts.*;
import static com.codeborne.selenide.Condition.*;
import static pages.HomePage.*;
import static pages.ItemsAfterSearchPage.*;

public class SearchLineSteps {
    @When("Нажимаем на поисковую строку")
    public void clickOnSearchline() {
        searchLine.shouldBe(visible).click();
    }

    @And("Вводим {string} в поисковую строку, нажимаем ENTER")
    public void sendKeysToSearchline(String arg0) {
        new HomePage().searchItem(arg0);
    }

    @And("Нажимаем кнопку крестика на поисковой строке")
    public void clearSearchline() {
        crossBtn.shouldBe(visible, interactable).hover().shouldBe(visible, interactable).click();
    }

    @Then("На странице присутствует текст {string}")
    public void pageContainsText(String arg0) {
        verifyTextOnElement(arg0, titleAfterSearch);
    }

    @And("Первый фильтр содержит текст {string}")
    public void firstFilterContainsText(String arg0) {
        verifyTextOnElement(arg0, filterForItems);
    }

    @And("Выдача товаров отсортирована {string}")
    public void sortingType(String arg0) {
        verifyTextOnElement(arg0, sortBtn);
    }

    @And("У первого товара бренд {string}")
    public void brandOfFirstItem(String arg0) {
        verifyTextOnElement(arg0, brandOfFirstItem);
    }

    @And("Строка поиска стала пустой")
    public void searchlineIfClear() {
        verifyTextOnElement("", searchLine);
    }
}
