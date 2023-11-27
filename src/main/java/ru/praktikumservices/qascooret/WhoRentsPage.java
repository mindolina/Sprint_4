package ru.praktikumservices.qascooret;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class WhoRentsPage extends BasePage {


    private final By name = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Имя']");
    private final By surname = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Фамилия']");
    private final By address = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metro = By.xpath(".//div[@class='select-search__value']/input");
    private final By metroSelect = By.xpath(".//div[@class='select-search__select']");
    private final By phone = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By next = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");

    public WhoRentsPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void setName(String userName) {
        webDriver.findElement(name).sendKeys(userName);
    }

    public void setSurname(String userSurname) {
        webDriver.findElement(surname).sendKeys(userSurname);
    }

    public void setAddress(String userAddress) {
        webDriver.findElement(address).sendKeys(userAddress);
    }

    public void setMetro(String userMetro) {
        webDriver.findElement(metro).click();
        webDriver.findElement(metro).sendKeys(userMetro);
        webDriver.findElement(metroSelect).click();
    }

    public void setPhone(String userPhone) {
        webDriver.findElement(phone).sendKeys(userPhone);
    }

    public void clickNext() {
        webDriver.findElement(next).click();
    }

    public void whoRents(String userName, String userSurname, String userAddress, String userMetro, String userPhone) {
        setName(userName);
        setSurname(userSurname);
        setAddress(userAddress);
        setMetro(userMetro);
        setPhone(userPhone);
        clickNext();

    }
}
