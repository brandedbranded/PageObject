import static assertForTests.Asserts.checkTextContainsOnPage;
import static assertForTests.Asserts.verifyClickable;
import static assertForTests.Asserts.verifyPriceOnElement;
import static assertForTests.Asserts.verifyQuantityOnPage;
import static assertForTests.Asserts.verifyRedirectToHomePage;
import static assertForTests.Asserts.verifyTextOnElement;
import static common.Constants.ITEM;
import static common.Constants.WB_PAGE;
import static pages.AddressPage.aboutPointAddress;
import static pages.AddressPage.chooseAddressBtn;
import static pages.AddressPage.getAddressFromList;
import static pages.AddressPage.searchBoxInAddress;
import static pages.BasketPage.orderBtn;
import static pages.BasketPage.priceInsideBasket;
import static pages.BasketPage.sumPriceInBasket;
import static pages.FilterHomePage.electronicsBtn;
import static pages.FilterHomePage.homeAppliancesBtn;
import static pages.FilterHomePage.householdBtn;
import static pages.FilterHomePage.laptops;
import static pages.FilterHomePage.laptopsAndPc;
import static pages.FilterHomePage.vacuums;
import static pages.FiltresAfterSearchPage.brandApple;
import static pages.FiltresAfterSearchPage.lessThan3DaysBtn;
import static pages.FiltresAfterSearchPage.priceMax;
import static pages.FiltresAfterSearchPage.priceMin;
import static pages.FiltresAfterSearchPage.screen133;
import static pages.FiltresAfterSearchPage.showItemsWithFiltres;
import static pages.HomePage.addressBtn;
import static pages.HomePage.basketBtn;
import static pages.HomePage.counterAboveBasket;
import static pages.HomePage.crossBtn;
import static pages.HomePage.filterBtn;
import static pages.HomePage.searchLine;
import static pages.HomePage.visibleAddressOfChosenPoint;
import static pages.ItemsAfterSearchPage.addToBasket;
import static pages.ItemsAfterSearchPage.allFiltres;
import static pages.ItemsAfterSearchPage.brandOfFirstItem;
import static pages.ItemsAfterSearchPage.catalogTitle;
import static pages.ItemsAfterSearchPage.filterForItems;
import static pages.ItemsAfterSearchPage.filterPath;
import static pages.ItemsAfterSearchPage.firstVacuum;
import static pages.ItemsAfterSearchPage.getNameOfItem;
import static pages.ItemsAfterSearchPage.getPriceOfItem;
import static pages.ItemsAfterSearchPage.listOfFiltres;
import static pages.ItemsAfterSearchPage.sortBtn;
import static pages.ItemsAfterSearchPage.titleAfterSearch;

import common.Config;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

public class WbTests extends Config {

    @Test
    @DisplayName("Работа с поисковой строкой")
    @Description("Присутствует текст Iphone 13. Первый фильтр - iphone 13. Применен фильтр По популярности. У первого устройства из списка бренд - Apple.")
    public void searchForItemTest() {
        homePage
            .hoverClick(searchLine)
            .sendKeysToInput(searchLine, ITEM + Keys.ENTER);

        verifyTextOnElement(ITEM, titleAfterSearch);
        verifyTextOnElement(ITEM, filterForItems);
        verifyTextOnElement("По популярности", sortBtn);
        verifyTextOnElement("Apple", brandOfFirstItem);

        homePage.
            hoverClick(crossBtn);

        verifyTextOnElement("", searchLine);
    }

    @Test
    @DisplayName("Смена города")
    @Description("Адрес пункта выдачи совпадает с тем адресом, что был предложен в списке адресов. Отображается адрес пункта выдачи.")
    public void changeCityTest() {
        homePage
            .hoverClick(addressBtn);
        addressPage
            .sendKeysToInput(searchBoxInAddress, "Санкт-петербург" + Keys.ENTER);

        String address = getAddressFromList();
        verifyTextOnElement(address, aboutPointAddress);

        addressPage
            .hoverClick(chooseAddressBtn);

        verifyTextOnElement(address, visibleAddressOfChosenPoint);
        verifyRedirectToHomePage(WB_PAGE);
    }

    @Test
    @DisplayName("Добавление товара в избранное")
    @Description("Товар добавляется в избранное, счетчик изменяется")
    public void addItemToFavorite() {
        homePage
            .hoverClick(filterBtn);
        filterHomePage
            .hover(householdBtn)
            .click(homeAppliancesBtn)
            .hoverClick(vacuums);

        verifyTextOnElement("Главная\n"
            + "Бытовая техника\n"
            + "Техника для дома\n"
            + "Пылесосы и пароочистители", filterPath);
        verifyTextOnElement("Пылесосы и пароочистители", catalogTitle);

        itemsAfterSearchPage
            .hover(firstVacuum)
            .hoverClick(addToBasket);

        String nameItem = getNameOfItem();
        String itemPrice = getPriceOfItem();
        verifyTextOnElement("1", counterAboveBasket);

        homePage
            .hoverClick(basketBtn);

        verifyPriceOnElement(itemPrice, priceInsideBasket);
        checkTextContainsOnPage(nameItem);
        verifyPriceOnElement(itemPrice, sumPriceInBasket);
        verifyClickable(orderBtn);
    }

    @Test
    @DisplayName("Работа с фильтрами")
    @Description("Фильтр активен, фильтр отображается на странице, есть кнопка Сбросить всё")
    public void useFiltres() {
        homePage
            .hoverClick(filterBtn);
        filterHomePage
            .hover(electronicsBtn)
            .click(laptopsAndPc)
            .hoverClick(laptops);

        verifyTextOnElement("Ноутбуки и ультрабуки", catalogTitle);

        filtresAfterSearchPage
            .hoverClick(allFiltres)
            .sendKeysToInput(priceMin, "100000")
            .sendKeysToInput(priceMax, "149000")
            .hoverClick(lessThan3DaysBtn)
            .hoverClick(brandApple)
            .hoverClick(screen133)
            .hoverClick(showItemsWithFiltres);

        verifyTextOnElement("до 3 дней", listOfFiltres);
        verifyTextOnElement("Apple", listOfFiltres);
        verifyTextOnElement("13", listOfFiltres);
        verifyTextOnElement("Сбросить все", listOfFiltres);
        verifyQuantityOnPage();
    }
}
