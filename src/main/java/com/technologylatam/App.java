package com.technologylatam;

import com.technologylatam.config.ConfigReader;
import com.technologylatam.driver.DriverFactory;
import org.openqa.selenium.WebDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        WebDriver driver = DriverFactory.getDriver();

        System.out.println(driver);

        driver.get("https://www.google.cl");

        Thread.sleep(5000);

        driver.quit();
    }
}
