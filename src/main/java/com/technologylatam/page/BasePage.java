package com.technologylatam.page;

import com.technologylatam.config.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected BasePage(WebDriver driver){
        this.driver = driver;

        Duration timeout = Duration.ofSeconds(Long.parseLong(ConfigManager.getExplicitWait()));
        this.wait = new WebDriverWait(driver, timeout);
    }

    protected void goTo(){
        driver.get(ConfigManager.getBaseUrl());
    }

    protected void back(){
        driver.navigate().back();
    }

    protected void forward(){
        driver.navigate().forward();
    }

    protected void refresh(){
        driver.navigate().refresh();
    }

    protected WebElement find(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> findAll(By locator){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void write (By locator){
        wait.until(ExpectedConditions.elementToBeSelected(locator));
    }

    protected String getText (By locator){
        return find(locator).getText();
    }

}
