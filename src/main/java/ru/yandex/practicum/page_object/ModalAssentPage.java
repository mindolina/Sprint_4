package ru.yandex.practicum.page_object;
;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class ModalAssentPage {
private final WebDriver webDriver;

private By buttonAssent = By.xpath(".//button[text()='Да']");
private By modalOrder = By.className ("Order_NextButton__1_rCA");




public ModalAssentPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

public void clickButtonAssent(){
    new WebDriverWait(webDriver, 3)
            .until(ExpectedConditions.elementToBeClickable(buttonAssent));
    webDriver.findElement(buttonAssent).click();
}
public void waitModalOrder(){
    new WebDriverWait(webDriver,3)
            .until(ExpectedConditions.visibilityOfElementLocated(modalOrder));

}

public void waitTextOrder(){
    String text = webDriver.findElement(By.className("Order_ModalHeader__3FDaJ")).getText();
    System.out.println(text);
}

}
