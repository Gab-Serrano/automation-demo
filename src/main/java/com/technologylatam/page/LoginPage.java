package com.technologylatam.page;

import com.technologylatam.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goTo(){
        super.goTo();
    }

    public void login(User user){
        typeUsername(user.getUsername());
        typePassword(user.getPassword());

        click(loginButton);
    }

    private void typeUsername (String username) {
        write(usernameInput, username);
    }

    private void typePassword (String password) {
        write(passwordInput, password);
    }

}
