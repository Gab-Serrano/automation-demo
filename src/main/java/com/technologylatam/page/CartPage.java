package com.technologylatam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage{

    private final By cartList = By.cssSelector("#cart_contents_container .cart_list");
    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductInCart(String product){
        List<WebElement> itemList = find(cartList).findElements(By.cssSelector(".cart_item a"));

        return itemList.stream()
                .anyMatch(e -> e.getText().trim().equalsIgnoreCase(product.trim()));
    }

    public void continueWithCheckout(){
        click(checkoutButton);
    }

}
