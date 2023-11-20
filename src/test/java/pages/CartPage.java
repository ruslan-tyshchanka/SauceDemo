package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By TITLE = By.cssSelector(".title");
    private String CART_ELEMENT = "//*[@class='cart_item']//*[@class='inventory_item_name' and text()='%s']";
    private String CART_ELEMENT_REMOVE_BUTTON = "//*[@class='inventory_item_name' and text()='%s']//ancestor::*[@class='cart_item']//*[text()='Remove']";
    public CartPage (WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/cart.html");
    }

    public int getItemInCart(String itemName) {
        By verifyElementInCart = By.xpath(String.format(CART_ELEMENT, itemName));
        return driver.findElements(verifyElementInCart).size();
    }

    public void removeElementFromCart(String itemName) {
        By elementToRemoveFromCart = By.xpath(String.format(CART_ELEMENT_REMOVE_BUTTON, itemName));
        driver.findElement(elementToRemoveFromCart).click();
    }
}
