package com.technologylatam.test;

import com.technologylatam.base.BaseTest;
import com.technologylatam.model.Cart;
import com.technologylatam.page.CartPage;
import com.technologylatam.page.HomePage;
import com.technologylatam.page.LoginPage;
import com.technologylatam.provider.DataProviders;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

@Slf4j
public class CartPageTest extends BaseTest {

    @Test(
            dataProvider = "cartData",
            dataProviderClass = DataProviders.class)
    public void shouldAddItemsToCartTest(Cart cartCheckout){
        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);

        //Login
            login.login(cartCheckout.getUser());
            assertTrue(home.isHeaderVisible());

            home.addFirstItemToCart();
            home.goToCart();

            assertTrue(cart.isProductInCart(cartCheckout.getItem()));
    }

}
