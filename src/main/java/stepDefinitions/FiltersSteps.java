package stepDefinitions;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;

import static assertForTests.Asserts.verifyQuantityOnPage;
import static assertForTests.Asserts.verifyTextOnElement;
import static assertForTests.Steps.hoverClick;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static pages.FiltresAfterSearchPage.*;
import static pages.ItemsAfterSearchPage.allFiltres;
import static pages.ItemsAfterSearchPage.listOfFiltres;

public class FiltersSteps {
    @And("Нажимаем кнопку фильтров")
    public void clickFiltersAfterSearch() {
        hoverClick(allFiltres);
    }

    @And("Выбираем {string}")
    public void selectFilter(String arg0) {
        SelenideElement element = $x("//span[contains(text(), '" + arg0 + "')]");
        hoverClick(element);
    }

    @And("Нажимаем кнопку Показать")
    public void clickShow() {
        hoverClick(showItemsWithFiltres);
    }

    @And("Количество товара на странице равно количеству товара на странице")
    public void amountOfItemsCorrect() {
        verifyQuantityOnPage();
    }

    @And("{string} и {string} отображаются на странице")
    public void filtersVisible(String arg0, String arg1) {
        verifyTextOnElement(arg0, listOfFiltres);
        verifyTextOnElement(arg1, listOfFiltres);
    }

    @And("Появилась кнопка {string}")
    public void appearedBtn(String arg0) {
        verifyTextOnElement(arg0, listOfFiltres);
    }

    @And("Вводим {string} и {string}")
    public void inputPrice(String arg0, String arg1) {
        priceMin.shouldBe(visible, enabled).clear();
        priceMax.shouldBe(visible, enabled).clear();
        priceMax.shouldBe(visible, enabled).clear();
        priceMin.shouldBe(visible, enabled, editable, empty).sendKeys(arg0);
        priceMax.shouldBe(visible, enabled, editable, empty).sendKeys(arg1);
    }
}
