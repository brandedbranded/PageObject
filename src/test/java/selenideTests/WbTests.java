package selenideTests;

import common.*;
import io.qameta.allure.*;
import io.qameta.allure.junit4.*;
import org.junit.*;

import static assertForTests.Asserts.*;
import static common.Constants.*;
import static pages.FiltresAfterSearchPage.*;
import static pages.ItemsAfterSearchPage.*;

public class WbTests extends Config {

    @Feature("Поиск товара")
    @Story("Поиск iPhone 13 с помощью поисковой строки")
    @Severity(SeverityLevel.MINOR)
    @Owner("Artyom G")
    @Test
    @DisplayName("Работа с поисковой строкой")
    @Description("Присутствует текст Iphone 13. Первый фильтр - iphone 13. Применен фильтр По популярности. У первого устройства из списка бренд - Apple.")
    public void searchForItemTest() {
        homePage
                .searchItem(ITEM)
                .clearSearchLineWithCross();
    }

    @Feature("Смена города доставки")
    @Story("Изменение адреса пункта выдачи для доставки товаров")
    @Severity(SeverityLevel.MINOR)
    @Owner("Artyom G")
    @Test
    @DisplayName("Смена города")
    @Description("Адрес пункта выдачи совпадает с тем адресом, что был предложен в списке адресов. Отображается адрес пункта выдачи.")
    public void changeCityTest() {
        homePage
                .openAddress()
                .inputCityName("Санкт-петербург")
                .openFirstAddress(address)
                .chooseFirstAddress(address2);

        verifyEquality(address.toString(), address2.toString());
    }

    @Feature("Добавление товара в корзину")
    @Story("Добавление пылесоса, найденного с помощью фильтров на главной странице, в корзину")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Artyom G")
    @Test
    @DisplayName("Добавление товара в корзину")
    @Description("Товар добавляется в корзину, счетчик изменяется")
    public void addItemToCart() {
        homePage
                .openFilters()
                .hoverHouseHold()
                .chooseHomeAppliances()
                .chooseVacuums()
                .chooseFirstVacuum();

        String nameItem = getNameOfItem();
        String itemPrice = getPriceOfItem();

        homePage
                .goToCart(nameItem, itemPrice);
    }

    @Feature("Фильтрация товара")
    @Story("Применение фильтров на результат поиска")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Artyom G")
    @Test
    @DisplayName("Работа с фильтрами")
    @Description("Фильтр активен, фильтр отображается на странице, есть кнопка Сбросить всё")
    public void useFiltres() {
        homePage
                .openFilters()
                .hoverElectronics()
                .chooseLaptopsAndPC()
                .chooseLaptops()
                .openFilters()
                .fillPriceFilter("100000", "149000")
                .choose(lessThan3DaysBtn)
                .choose(brandApple)
                .choose(screen133)
                .choose(showItemsWithFiltres)
                .verifyFilters();
    }
}
