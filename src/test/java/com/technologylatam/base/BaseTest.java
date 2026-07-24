package com.technologylatam.base;

import com.technologylatam.config.ConfigManager;
import com.technologylatam.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod()
    public void setUp(){
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();

        driver.get(ConfigManager.getBaseUrl());
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

}
