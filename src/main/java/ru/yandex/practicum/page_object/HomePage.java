package ru.yandex.practicum.page_object;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practicum.page_object.components.FaqComponent;

public class HomePage {
    private final WebDriver webDriver;
    //Список в разделе "Вопросы о важном"
    private By faq = By.xpath(".//div[@class='accordion__item']");


    //Кнопка "Заказать" вверху страницы
    private By orderButtonHeader = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    //Кнопка "Заказать" внизу страницы
    private By orderButtonHomeDown= By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");


    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    //открыть страницу
    public void open()
    {
        webDriver.get ("https://qa-scooter.praktikum-services.ru/");
    }

    //метод для нажатия на "Заказать" вверху страницы
   public void clickOrderButtonHeader(String buttonLocated){
        if (buttonLocated=="заказать вверху страницы")
       webDriver.findElement(orderButtonHeader).click();
        else if (buttonLocated=="заказать внизу страницы"){
            WebElement down = webDriver.findElement(orderButtonHomeDown);
            ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", down);
            webDriver.findElement(orderButtonHomeDown).click();
        }
   }

    //метод для нажатия на "Заказать" внизу страницы
    public void clickOrderButtonHomeDown(){
        webDriver.findElement(orderButtonHomeDown).click();
    }

    //
    public FaqComponent getFaqComponent (int index){
       WebElement webElement= webDriver.findElements(faq).get(index);
      return new FaqComponent(webElement,webDriver);
    }

}

