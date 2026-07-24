package com.technologylatam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By finishButton = By.id("finish");
    private final By completeHeader = By.cssSelector("#checkout_complete_container > .complete-header");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void typeFirstName(String firstName){
        write(firstNameInput, firstName);
    }

    public void typeLastName(String lastName){
        write(lastNameInput, lastName);
    }

    public void typePostalCode(String postalCode){
        write(postalCodeInput, postalCode);
    }

    public void continueWithCheckout(){
        click(continueButton);
    }

    public void finishCheckout() {
        click(finishButton);
    }

    public String getSuccessMessage(){
        return getText(completeHeader);
    }
}
