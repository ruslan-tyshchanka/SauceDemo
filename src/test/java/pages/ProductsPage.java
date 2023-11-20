package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends  BasePage {

    private final By TITLE = By.cssSelector(".title");
    private String ADD_TO_CART_BUTTON = "//*[text()='%s']//ancestor::div[@class='inventory_item']//*[text()='Add to cart']";
    private final By CART = By.id("shopping_cart_container");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }
    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void addItemToCart (String itemName) {
        By addToCartButton = By.xpath(String.format(ADD_TO_CART_BUTTON, itemName));
        driver.findElement(addToCartButton).click();
    }

    public void openCart () {
        driver.findElement(CART).click();
    }
}
