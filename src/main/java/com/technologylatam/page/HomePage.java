package com.technologylatam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage extends BasePage{

    private final By headerContainer = By.id("header_container");
    private final By cartContainer = By.id("shopping_cart_container");
    private final By inventoryList = By.cssSelector("#inventory_container > .inventory_list");
    private final By inventoryItems = By.cssSelector("#inventory_container > .inventory_list > .inventory_item");
    private final By sortContainer = By.className("product_sort_container");
    private final By inventoryPrices = By.cssSelector("#inventory_container > .inventory_list > .inventory_item .inventory_item_price");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void goTo(){
        super.goTo();
    }

    public boolean isHeaderVisible (){
        return isVisible(headerContainer);
    }

    public boolean areInventoryItemsVisibles(){
        return areChildrenVisibles(inventoryList, inventoryItems);
    }

    private List<WebElement> getAllInventoryItems(){
        return findAll(inventoryItems);
    }

    public void addFirstItemToCart(){
        WebElement itemToBuy = getAllInventoryItems().get(0);

        WebElement addToCartButton = itemToBuy.findElement(By.cssSelector(".pricebar > .btn"));

        addToCartButton.click();
    }

    public boolean areThereItemsInCart(){
        WebElement cart = find(cartContainer);
        List<WebElement> cartBadge = cart.findElements(By.cssSelector(".shopping_cart_link .shopping_cart_badge"));

        if (!cartBadge.isEmpty()){
            return isVisible(cartBadge.get(0));
        }

        return false;
    }

    public void sortByPriceHighToLow(){

        Select sort = new Select(find(sortContainer));

        sort.selectByValue("hilo");
    }

    public void goToCart(){
        find(cartContainer).click();
    }

    private List<WebElement> getAllInventoryPrices(){
        return findAll(inventoryPrices);
    }

    private double getFirstItemPrice(){

        String price = getAllInventoryPrices()
                .get(0)
                .getText();

        return Double.parseDouble(price.replace("$", ""));
    }

    private double getLastItemPrice(){

        List<WebElement> prices = getAllInventoryPrices();

        String price = prices
                .get(prices.size() - 1)
                .getText();

        return Double.parseDouble(price.replace("$", ""));
    }

    public boolean areProductsSortedByPriceDesc(){

        return getFirstItemPrice() > getLastItemPrice();

    }

}
