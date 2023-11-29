package ru.praktikumservices.pageobject;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.startsWith;


public class ModalAssentPage extends BasePage {


    private final By buttonAssent = By.xpath(".//button[text()='Да']");
    private final By modalOrderReady = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    public ModalAssentPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void clickButtonAssent() {
        webDriver.findElement(buttonAssent).click();
    }


    public void waitTextOrder(String orderReady) {
        String text = webDriver.findElement(modalOrderReady).getText();
        MatcherAssert.assertThat("должен быть текст: Заказ оформлен ", text, startsWith(orderReady));

    }

}
