package ru.praktikumservices.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.praktikumservices.pageobject.components.FaqComponent;

public class HomePage extends BasePage {
    private final By faq = By.xpath(".//div[@class='accordion__item']");
    private final By orderButtonHeader = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    private final By orderButtonHomeDown = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void open() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }


    public void clickOrderButtonHeader(String buttonLocated) {
        if (buttonLocated == "заказать вверху страницы")
            webDriver.findElement(orderButtonHeader).click();
        else if (buttonLocated == "заказать внизу страницы") {
            WebElement down = webDriver.findElement(orderButtonHomeDown);
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", down);
            webDriver.findElement(orderButtonHomeDown).click();
        }
    }


    public FaqComponent getFaqComponent(int index) {
        WebElement webElement = webDriver.findElements(faq).get(index);
        return new FaqComponent(webElement, webDriver);
    }

}

