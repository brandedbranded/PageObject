package stepDefinitions;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static assertForTests.Asserts.*;
import static assertForTests.Steps.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertTrue;
import static pages.BasketPage.*;
import static pages.HomePage.*;
import static pages.ItemsAfterSearchPage.*;

public class AddToCartSteps {

    List<String> categories = new ArrayList<>();
    StringBuilder nameOfItem = new StringBuilder();
    StringBuilder priceOfItem = new StringBuilder();

    @When("Нажимаем на кнопку фильтров")
    public void clickFilter() {
        hoverClick(filterBtn);
    }

    @And("Наводим курсор на {string}")
    public void hoverCategory1(String arg0) {
        SelenideElement element = $(By.linkText(arg0));
        categories.add("Главная");
        categories.add(arg0);
        hover(element);
    }

    @And("Нажимаем на появившийся текст справа: {string}")
    public void clickCategory(String arg0) {
        SelenideElement element = $x("//span[contains(text(), '" + arg0 + "')]");
        categories.add(arg0);
        hoverClick(element);
    }

    @And("Нажимаем на появившийся текст справа с третьей категорией: {string}")
    @And("Нажимаем на категорию {string}")
    public void clickThirdCateg(String arg0) {
        SelenideElement element = $x("//a[contains(text(), '" + arg0 + "')]");
        categories.add(arg0);
        hoverClick(element);
    }

    @And("Наводим курсор на первый товар выдачи")
    public void hoverFirstItem() {
        SelenideElement el = $x("//a[@class='product-card__link j-card-link j-open-full-product-card']");
        hover(el);
    }

    @And("Нажимаем кнопку В корзину")
    public void addToCart() {
        hoverClick(addToBasket);
        nameOfItem.append(getNameOfItem());
        priceOfItem.append(getPriceOfItem());
    }

    @And("Нажимаем кнопку корзины в правом верхнем углу")
    public void goToCart() {
        hoverClick(basketBtn);
    }

    @Then("Произошел переход на страницу с {string}")
    public void itemsPageWithCategoryOpened(String arg0) {
        assertTrue(catalogTitle.getText().contains(arg0));
    }

    @And("Путь фильтра соответствует Главная  {string}  {string}  {string}")
    public void filterCorrect(String arg0, String arg1, String arg2) {
        String filters = categories.toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", "").toLowerCase();
        String pathFilter = filterPath.getText().replace(" ", "").replace("\n", "").toLowerCase();
        assertTrue(filters.contains(pathFilter));
    }

    @And("В правом верхнем углу над логотипом {string} появилась красная цифра {string}")
    public void counterActive(String arg0, String arg1) {
        verifyTextOnElement(arg1, counterAboveBasket);
    }

    @And("Текст и цена товара соответствует цене и названию товара из выдачи товаров")
    public void nameAndPriceCorrect() {
        verifyPriceOnElement(priceOfItem.toString(), priceInsideBasket);
        verifyEquality(nameOfItem.toString(), getNameInBasket());
    }

    @And("Поле {string} равняется цене товара")
    public void sumEqualsPrice(String arg0) {
        verifyPriceOnElement(priceOfItem.toString(), sumPriceInBasket);
    }

    @And("Кнопка {string} кликабельна")
    public void orderBtnClickable(String arg0) {
        verifyClickable(orderBtn);
    }
}
