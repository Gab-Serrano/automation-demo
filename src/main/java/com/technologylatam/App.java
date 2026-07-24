package com.technologylatam;

import com.technologylatam.driver.DriverFactory;
import com.technologylatam.model.User;
import com.technologylatam.page.CartPage;
import com.technologylatam.page.CheckoutPage;
import com.technologylatam.page.HomePage;
import com.technologylatam.page.LoginPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

/**
 * Hello world!
 *
 */
@Slf4j
public class App 
{

    public static void main(String[] args ) {

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
        homePage.addFirstItemToCart();
        homePage.goToCart();
        log.info("Cart: {}",cartPage.isProductInCart("Sauce Labs Backpack"));
        cartPage.continueWithCheckout();
        checkoutPage.typeFirstName("Gabriel");
        checkoutPage.typeLastName("Serrano");
        checkoutPage.typePostalCode("342352");
        checkoutPage.continueWithCheckout();
        checkoutPage.finishCheckout();
        log.info("check: {}", checkoutPage.getSuccessMessage());

        driver.quit();

    }
}
