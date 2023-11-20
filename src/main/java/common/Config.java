package common;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.AddressPage;
import pages.BasketPage;
import pages.FilterHomePage;
import pages.FiltresAfterSearchPage;
import pages.HomePage;
import pages.ItemCardPage;
import pages.ItemsAfterSearchPage;

public class Config {

    protected AddressPage addressPage = new AddressPage();
    protected BasketPage basketPage = new BasketPage();
    protected FilterHomePage filterHomePage = new FilterHomePage();
    protected FiltresAfterSearchPage filtresAfterSearchPage = new FiltresAfterSearchPage();
    protected HomePage homePage = new HomePage();
    protected ItemCardPage itemCardPage = new ItemCardPage();
    protected ItemsAfterSearchPage itemsAfterSearchPage = new ItemsAfterSearchPage();

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 5000;
    }

    public void openBrowser(String url) {
        Selenide.open(url);
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
