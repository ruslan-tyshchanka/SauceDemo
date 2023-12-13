package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsPage extends  BasePage {

    private final By TITLE = By.cssSelector(".title");
    private String ADD_TO_CART_BUTTON = "//*[text()='%s']//ancestor::div[@class='inventory_item']//*[text()='Add to cart']";
    private String REMOVE_FROM_CART_BUTTON = "//*[text()='%s']//ancestor::div[@class='inventory_item']//*[text()='Remove']";
    private final By CART = By.id("shopping_cart_container");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    @Step("Get product title")
    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Step("Add item {itemName} to cart")
    public void addItemToCart (String itemName) {
        By addToCartButton = By.xpath(String.format(ADD_TO_CART_BUTTON, itemName));
        driver.findElement(addToCartButton).click();
    }

    @Step("Remove item {itemName} from cart")
    public void removeItemFromCart (String itemName) {
        By removeFromCartButton = By.xpath(String.format(REMOVE_FROM_CART_BUTTON, itemName));
        driver.findElement(removeFromCartButton).click();
    }

    @Step("Verify presence of 'Add to cart' button for item {itemName}")
    public int verifyAddToCartButton (String itemName) {
        By addToCartButton = By.xpath(String.format(ADD_TO_CART_BUTTON, itemName));
        return driver.findElements(addToCartButton).size();
    }

    @Step("Verify presence of 'Remove' button for item {itemName}")
    public int verifyRemoveFromCartButton (String itemName) {
        By removeFromCartButton = By.xpath(String.format(REMOVE_FROM_CART_BUTTON, itemName));
        return driver.findElements(removeFromCartButton).size();
    }

    @Step("Open cart")
    public void openCart () {
        driver.findElement(CART).click();
    }
}
