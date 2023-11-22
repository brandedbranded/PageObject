package common;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.HomePage;

import java.time.LocalDate;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

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
}
