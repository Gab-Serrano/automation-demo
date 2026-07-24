package com.technologylatam.test;

import com.technologylatam.base.BaseTest;
import com.technologylatam.model.Checkout;
import com.technologylatam.page.CartPage;
import com.technologylatam.page.CheckoutPage;
import com.technologylatam.page.HomePage;
import com.technologylatam.page.LoginPage;
import com.technologylatam.provider.DataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutPageTest extends BaseTest {

    @Test(
            dataProvider = "checkoutData",
            dataProviderClass = DataProviders.class
    )
    public void shouldCompletePurchaseSuccessfully(Checkout checkout){

        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        login.login(checkout.getUser());

        assertTrue(home.isHeaderVisible());

        home.addFirstItemToCart();

        assertTrue(home.areThereItemsInCart());

        home.goToCart();

        cart.continueWithCheckout();

        checkoutPage.typeFirstName(checkout.getFirstName());
        checkoutPage.typeLastName(checkout.getLastName());
        checkoutPage.typePostalCode(checkout.getPostalCode());

        checkoutPage.continueWithCheckout();

        checkoutPage.finishCheckout();

        assertEquals(
                checkoutPage.getSuccessMessage(),
                "Thank you for your order!"
        );
    }

}
