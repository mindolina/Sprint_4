package ru.yandex.practicum.page_object;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
public class DetaisRentsPage {
    private final WebDriver webDriver;

    private By date = By.xpath(".//div[@class='react-datepicker__input-container']/input");
    private By time = By.xpath(".//div[text()='* Срок аренды']");
    private By timeMenu = By.xpath(".//div[@class='Dropdown-menu']");
    private By timeOneDay = By.xpath (".//div[@class='Dropdown-menu']/div[text()='сутки']");
    private By timeSevenDay = By.xpath (".//div[@class='Dropdown-menu']/div[text()='семеро суток']");

    private By colorBlack = By.xpath(".//input[@id='black']");
    private By colorGrey = By.xpath(".//input[@id='grey']");
    private By comment = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='Комментарий для курьера']");
    private By buttonOrder = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    public DetaisRentsPage(WebDriver webDriver){
        this.webDriver = webDriver;}

    public void setDate (String userDate){
        webDriver.findElement(date).sendKeys(userDate, Keys.ENTER);
    }
    public void setTime (String userTime){
        webDriver.findElement(time).click();
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(timeOneDay));

        if (userTime=="сутки"){
            webDriver.findElement(timeOneDay).click();}
            else if (userTime=="семеро суток"){
                WebElement element = webDriver.findElement(timeSevenDay);
            ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
                webDriver.findElement(timeSevenDay).click();
            }
        }




    public void setColor (String userColorScooter){
        if (userColorScooter=="чёрный жемчуг"){
        webDriver.findElement(colorBlack).click();}
        else if(userColorScooter=="серая безысходность"){
            webDriver.findElement(colorGrey).click();
        }

    }
    public void setComment (String userComment){
        webDriver.findElement(comment).sendKeys(userComment);
    }
    public void clickButtonOrder (){
        webDriver.findElement(buttonOrder).click();
    }
    public void detailRental(String userDate,String userTime,String userColorScooter,String userComment ){
        setDate(userDate);
        setTime(userTime);
        setColor(userColorScooter);
        setComment(userComment);
        clickButtonOrder();

    }

}
