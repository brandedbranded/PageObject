package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

import static assertForTests.Asserts.textContainsOnPage;
import static assertForTests.Asserts.verifyTextOnElement;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static pages.HomePage.crossBtn;
import static pages.HomePage.searchLine;
import static pages.ItemsAfterSearchPage.*;

public class SeacrhLineSteps {

    @When("Нажимаем на поисковую строку")
    public void clickSearchLine() {
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
        textContainsOnPage(arg0);
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
