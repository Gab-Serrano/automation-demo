package com.technologylatam.base;

import com.technologylatam.driver.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class BaseTest {

    protected WebDriver driver;
    protected JavascriptExecutor js;

    @BeforeMethod()
    public void setUp(){
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;

    }

    @AfterMethod
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

}
