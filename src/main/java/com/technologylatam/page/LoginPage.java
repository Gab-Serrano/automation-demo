package com.technologylatam.page;

import com.technologylatam.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends BasePage{

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By loginForm = By.cssSelector("#login_button_container .login-box form");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goTo(){
        super.goTo();
    }

    public void login(User user){
        typeUsername(user.getUsername());
        typePassword(user.getPassword());

        click(loginButton);
    }

    public Boolean hasLoginFailed (){
        WebElement form = find(loginForm);
        List<WebElement> errors = form.findElements(By.cssSelector(".error"));

        return !errors.isEmpty();
    }

    private void typeUsername (String username) {
        write(usernameInput, username);
    }

    private void typePassword (String password) {
        write(passwordInput, password);
    }

}
