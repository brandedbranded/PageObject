package pages;

import static assertForTests.Steps.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.*;
import org.openqa.selenium.*;

public class FilterHomePage {

    public static SelenideElement electronicsBtn = $x("//li[@data-menu-id='4830']");
    public static SelenideElement laptopsAndPc = $x(
        "//span[contains(text(), 'Ноутбуки и компьютеры')]");
    public static SelenideElement laptops = $(By.linkText("Ноутбуки"));
    public static SelenideElement householdBtn = $x("//li[@data-menu-id='16107']");
    public static SelenideElement homeAppliancesBtn = $x(
        "//span[contains(text(), 'Техника для дома')]");
    public static SelenideElement vacuums = $(By.linkText("Пылесосы и пароочистители"));

    public FilterHomePage hoverHouseHold() {
        hover(householdBtn);
        return new FilterHomePage();
    }

    public FilterHomePage chooseHomeAppliances() {
        hoverClick(homeAppliancesBtn);
        return new FilterHomePage();
    }

    public ItemsAfterSearchPage chooseVacuums() {
        hoverClick(vacuums);
        return new ItemsAfterSearchPage();
    }

    public FilterHomePage hoverElectronics() {
        hover(electronicsBtn);
        return new FilterHomePage();
    }

    public FilterHomePage chooseLaptopsAndPC() {
        hoverClick(laptopsAndPc);
        return new FilterHomePage();
    }

    public ItemsAfterSearchPage chooseLaptops() {
        hoverClick(laptops);
        return new ItemsAfterSearchPage();
    }
}
