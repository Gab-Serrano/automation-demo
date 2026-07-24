package com.technologylatam.driver;

import com.technologylatam.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public static WebDriver getDriver (){

        String browser = ConfigReader.getBrowser().toUpperCase();

        switch (browser){
            case "CHROME" -> {
                ChromeOptions options = new ChromeOptions();

                if(ConfigReader.isHeadless()){
                    options.addArguments("--headless=new");
                }

                return new ChromeDriver(options);
            }
            case "FIREFOX" -> {
                FirefoxOptions options = new FirefoxOptions();
                if (ConfigReader.isHeadless()) {
                    options.addArguments("-headless");
                }

                return new FirefoxDriver(options);
            }
            default -> {
                return new ChromeDriver();
            }
        }
    }

}
