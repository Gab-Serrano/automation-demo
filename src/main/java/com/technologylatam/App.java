package com.technologylatam;

import com.technologylatam.driver.DriverFactory;
import com.technologylatam.model.User;
import com.technologylatam.page.CartPage;
import com.technologylatam.page.CheckoutPage;
import com.technologylatam.page.HomePage;
import com.technologylatam.page.LoginPage;
import com.technologylatam.utils.JsonReader;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args ) throws InterruptedException {

        /*
        WebDriver driver = DriverFactory.getDriver();

        LoginPage login = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        User user = new User("standard_user", "secret_sauce");

        login.goTo();

        login.login(user);

        log.info("Hedaer: {}", homePage.isHeaderVisible());
        log.info("Intenvtory: {}", homePage.areInventoryItemsVisibles());
        homePage.addItemToCart();
        homePage.goToCart();
        log.info("Cart: {}",cartPage.isProductInCart("Sauce Labs Backpack"));
        cartPage.continueWithCheckout();
        checkoutPage.typeFirstName("Gabriel");
        checkoutPage.typeLastName("Serrano");
        checkoutPage.typePostalCode("342352");
        checkoutPage.continueWithCheckout();
        checkoutPage.finishCheckout();
        log.info("check: {}", checkoutPage.getSuccessMessage());


        Thread.sleep(3000);

        driver.quit();

        */

        System.out.println(JsonReader.read("user-data.json", List.class));

    }
}
