package common;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.*;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.*;
import io.qameta.allure.*;
import io.qameta.allure.selenide.*;
import org.junit.jupiter.api.*;
import pages.*;

import java.time.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Config {

    protected HomePage homePage = new HomePage();
    protected StringBuilder address = new StringBuilder();
    protected StringBuilder address2 = new StringBuilder();

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 5000;
    }

    @Given("Открываем сайт {string}")
    public void openBrowser(String url) {
        Selenide.open(url);
        $x("(//img[@class='j-thumbnail'])[1]").shouldBe(image, visible);
        $x("//body").should(exist, visible, enabled);
    }

    @BeforeEach
    @Step("Запуск браузера")
    public void init() {
        Allure.addAttachment("Дата запуска", getDate());
        Allure.addAttachment("Браузер", getBrowser());
        setUp();
        openBrowser("https://www.wildberries.ru/");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    public String getDate() {
        return String.valueOf(LocalDate.now());
    }

    public String getBrowser() {
        return "chrome.browser";
    }

    @AfterEach
    @Step("Закрытие браузера")
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    /*@When("Нажимаем на поисковую строку")
    public void нажимаемНаПоисковуюСтроку() {
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
    }*/
}
