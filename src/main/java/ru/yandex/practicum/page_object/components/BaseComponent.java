package ru.yandex.practicum.page_object.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseComponent {
    protected final WebElement root;
    protected final WebDriver webDriver;
    protected BaseComponent(WebElement root, WebDriver webDriver){
        this.root = root;
        this.webDriver=webDriver;
    }
}
