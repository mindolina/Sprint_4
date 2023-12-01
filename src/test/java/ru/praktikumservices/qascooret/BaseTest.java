package ru.praktikumservices.qascooret;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver webDriver;

    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @After
    public void teardown() {
        webDriver.quit();
    }
}
