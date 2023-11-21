package common;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.*;
import io.github.bonigarcia.wdm.*;
import org.junit.jupiter.api.*;
import pages.*;

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
    public void init() {
        setUp();
        openBrowser("https://www.wildberries.ru/");
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
