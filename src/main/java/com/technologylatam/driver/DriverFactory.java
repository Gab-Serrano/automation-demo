package com.technologylatam.driver;

import com.technologylatam.config.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public static WebDriver getDriver (){

        String browser = ConfigManager.getBrowser().toUpperCase();

        switch (browser){
            case "CHROME" -> {
                ChromeOptions options = new ChromeOptions();

                if(ConfigManager.isHeadless()){
                    options.addArguments("--headless=new");
                }
                if (ConfigManager.isIncognito()){

                    options.addArguments("--incognito");
                }

                return new ChromeDriver(options);
            }
            case "FIREFOX" -> {
                FirefoxOptions options = new FirefoxOptions();
                if (ConfigManager.isHeadless()) {
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
