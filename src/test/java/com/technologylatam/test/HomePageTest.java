package com.technologylatam.test;

import com.technologylatam.base.BaseTest;
import com.technologylatam.model.User;
import com.technologylatam.page.HomePage;
import com.technologylatam.page.LoginPage;
import com.technologylatam.provider.DataProviders;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomePageTest extends BaseTest {

    @Test(
            dataProvider = "homeData",
            dataProviderClass = DataProviders.class
    )
    public void shouldSortProductsByPriceHighToLow(User user){

        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);

        login.login(user);

        assertTrue(home.isHeaderVisible());

        home.sortByPriceHighToLow();

        assertTrue(home.areProductsSortedByPriceDesc());

    }
}
