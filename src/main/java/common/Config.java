package common;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
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
    public void browser() {
        browserType();
    }

    @Attachment(value = "Дата запуска теста", type = "text/html")
    public String dateOfTest() {
        return LocalDate.now().toString();
    }

    @BeforeEach
    public void date() {
        dateOfTest();
    }

    @Attachment(value = "Браузер, на котором проходил тест", type = "text/html")
    public String browserType() {
        return "chrome.browser";
    }

    @BeforeEach
    @Step("Запуск браузера")
    public void init() {
        setUp();
        openBrowser("https://www.wildberries.ru/");
    }

    @AfterEach
    @Step("Закрытие браузера")
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
