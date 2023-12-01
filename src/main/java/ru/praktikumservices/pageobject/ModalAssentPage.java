package ru.praktikumservices.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ModalAssentPage extends BasePage {


    private final By buttonAssent = By.xpath(".//button[text()='Да']");

    private final By buttonViewOrder = By.xpath(".//button[contains(text(),'Посмотреть статус')]");

    public ModalAssentPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void clickButtonAssent() {
        webDriver.findElement(buttonAssent).click();
    }

    public String getTextOrder() {

        return webDriver.findElement(buttonViewOrder).getText();
    }

}
