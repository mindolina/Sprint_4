package ru.yandex.practicum.scooter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.practicum.page_object.HomePage;
import ru.yandex.practicum.page_object.components.FaqComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;



@RunWith(Parameterized.class)
public class FaqTest {
    @Parameterized.Parameter
    public int index;
    private WebDriver webDriver;
    @Parameterized.Parameter(1)
    public String expectedQuestion;
    @Parameterized.Parameter(2)
    public String expectedAnswer;
    @Parameterized.Parameters
    public static Object [][] data (){
        return new Object[][]{
                {0, "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {3, "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {4, "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {5, "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {6, "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {7, "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {8, "Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."}

        };
    }


@Test
public void setup() {
    WebDriverManager.chromedriver().setup();
    webDriver = new ChromeDriver();
}
public void faqTest(){

    HomePage homePage = new HomePage(webDriver);
    homePage.open();
    FaqComponent faqComponent = homePage.getFaqComponent(index);
    faqComponent.openFaq();
    Assert.assertEquals(expectedQuestion,faqComponent.getQuestion());
    Assert.assertEquals(expectedAnswer, faqComponent.getAnswer());


}
    @After
    public void  teardown() {
        webDriver.quit();
    }
}
