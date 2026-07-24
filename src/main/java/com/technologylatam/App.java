package com.technologylatam;

import com.technologylatam.driver.DriverFactory;
import com.technologylatam.model.User;
import com.technologylatam.page.LoginPage;
import org.openqa.selenium.WebDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        WebDriver driver = DriverFactory.getDriver();

        LoginPage login = new LoginPage(driver);
        User user = new User("standard_user", "secret_sauce");

        login.goTo();

        login.login(user);

        Thread.sleep(5000);

        driver.quit();
    }
}
