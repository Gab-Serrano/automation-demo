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

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage(WebDriver driver){
        this.driver = driver;

        Duration timeout = Duration.ofSeconds(Long.parseLong(ConfigManager.getExplicitWait()));
        this.wait = new WebDriverWait(driver, timeout);
    }

    protected void goTo(){
        driver.get(ConfigManager.getBaseUrl());
    }

    protected WebElement find(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> findAll(By locator){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void write (By locator, String text){
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        input.clear();
        input.sendKeys(text);
    }

    protected String getText (By locator){
        return find(locator).getText();
    }

    protected boolean isVisible (By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    protected boolean isVisible (WebElement element){
        return wait.until((ExpectedConditions.visibilityOf(element))).isDisplayed();
    }

    protected boolean areChildrenVisibles(By parentLocator, By childrenLocator){
        return !wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(parentLocator, childrenLocator)).isEmpty();
    }

}
