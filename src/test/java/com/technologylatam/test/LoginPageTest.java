package com.technologylatam.test;

import com.technologylatam.base.BaseTest;
import com.technologylatam.model.User;
import com.technologylatam.page.LoginPage;
import com.technologylatam.provider.DataProviders;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginPageTest extends BaseTest {

    @Test(
            dataProvider = "userData",
            dataProviderClass = DataProviders.class)
    public void shouldntLogInvalidUser(User user){
        LoginPage login = new LoginPage(driver);
        login.login(user);

        assertTrue(login.hasLoginFailed());
    }
}
