package ru.yandex.practicum.page_object;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WhoRentsPage {

    private final WebDriver webDriver;
    private By name = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Имя']");
    private By surname = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Фамилия']");
    private By address = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Адрес: куда привезти заказ']");
    private By metro = By.xpath(".//div[@class='select-search__value']/input");
    private By metroSelect = By.xpath(".//div[@class='select-search__select']");
    private By phone = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Телефон: на него позвонит курьер']");
    private By next = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");

    public WhoRentsPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void setName (String userName) {
        webDriver.findElement(name).sendKeys(userName);
    }
    public void setSurname (String userSurname){
        webDriver.findElement(surname).sendKeys(userSurname);
    }
    public void setAddress (String userAddress){
        webDriver.findElement(address).sendKeys(userAddress);
    }
    public void setMetro (String userMetro){
        webDriver.findElement(metro).click();
        webDriver.findElement(metro).sendKeys(userMetro);
        webDriver.findElement(metroSelect).click();
    }
    public void setPhone (String userPhone){
        webDriver.findElement(phone).sendKeys(userPhone);
    }
    public void clickNext(){
        webDriver.findElement(next).click();
    }
    public void whoRents (String userName, String userSurname,String userAddress, String userMetro,String userPhone){
        setName(userName);
        setSurname(userSurname);
        setAddress(userAddress);
        setMetro(userMetro);
        setPhone(userPhone);
        clickNext();

    }
}
