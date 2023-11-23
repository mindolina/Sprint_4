package ru.yandex.practicum.page_object.components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaqComponent extends BaseComponent{
    private By question = By.xpath(".//div[@id='accordion__heading-0']");
    private By answer = By.xpath(".//div[@id='accordion__panel-0']/p");

    public FaqComponent(WebElement root,WebDriver webDriver){
        super(root,webDriver);

    }


    public String getQuestion (){
        return root.findElement(question).getText();
    }
    public String getAnswer(){
        return root.findElement(answer).getText();
    }
    public void openFaq (){
         WebDriverWait webDriverWait= new WebDriverWait(webDriver,10);
         webDriverWait
                .until(ExpectedConditions.presenceOfElementLocated(this.question));
         WebElement faqElement = root.findElement(question);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", faqElement);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(faqElement));
        faqElement.click();
    }
}
