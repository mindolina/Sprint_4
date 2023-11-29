package ru.praktikumservices.qascooret;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.praktikumservices.pageobject.DetaisRentsPage;
import ru.praktikumservices.pageobject.HomePage;
import ru.praktikumservices.pageobject.ModalAssentPage;
import ru.praktikumservices.pageobject.WhoRentsPage;

import java.util.concurrent.TimeUnit;


@RunWith(Parameterized.class)
public class OrderTest {
    @Parameterized.Parameter
    public String browserType;
    private WebDriver webDriver;
    @Parameterized.Parameter(1)
    public String buttonLocated;

    @Parameterized.Parameter(2)
    public String userName;
    @Parameterized.Parameter(3)
    public String userSurmame;
    @Parameterized.Parameter(4)
    public String userAddress;
    @Parameterized.Parameter(5)
    public String userMetro;
    @Parameterized.Parameter(6)
    public String userPhone;
    @Parameterized.Parameter(7)
    public String userDate;
    @Parameterized.Parameter(8)
    public String userTime;
    @Parameterized.Parameter(9)
    public String userColorScooter;
    @Parameterized.Parameter(10)
    public String userComment;
    @Parameterized.Parameter(11)
    public String orderReady;


    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {"chrome", "заказать вверху страницы", "Гарри", "Поттер", "Чулан под лестницей", "Царицыно", "11111111111", "01.01.2024", "сутки", "чёрный жемчуг", "это правда или это у меня в голове?", "Заказ оформлен"},
                {"firefox", "заказать внизу страницы", "Том", "Реддл", "приют", "Красные ворота", "22222222222", "31.12.1935", "семеро суток", "серая безысходность", "это моё прошлое, настоящее и будущее", "Заказ оформлен"}
        };
    }


    @Before
    public void setup() {
        if (browserType.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if (browserType.equals("firefox")) {
            WebDriverManager.firefoxdriver().clearDriverCache().clearResolutionCache().setup();
            webDriver = new FirefoxDriver();
        }
    }


    @Test
    public void orderShouldBeCompleted() {
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        HomePage homePage = new HomePage(webDriver);
        homePage.open();
        homePage.clickOrderButtonHeader(buttonLocated);

        WhoRentsPage whoRentsPage = new WhoRentsPage(webDriver);
        whoRentsPage.whoRents(userName, userSurmame, userAddress, userMetro, userPhone);

        DetaisRentsPage detaisRentsPage = new DetaisRentsPage(webDriver);
        detaisRentsPage.detailRental(userDate, userTime, userColorScooter, userComment);

        ModalAssentPage modalAssentPage = new ModalAssentPage(webDriver);
        modalAssentPage.clickButtonAssent();
        modalAssentPage.waitTextOrder(orderReady);
    }

    @After
    public void teardown() {
        webDriver.quit();
    }
}
