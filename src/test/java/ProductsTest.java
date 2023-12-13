import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Log4j2
public class ProductsTest extends  BaseTest {

    @Test
    public void verifyProductAttributesInCart() {
        log.info("Loggin in with valid credentials");
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String title = driver.findElement(By.cssSelector(".title")).getText();
        assertEquals(title, "Products", "User is not logged in or wrong page");

        String productName = "Sauce Labs Fleece Jacket";
        log.info("Adding item '{}' in cart", productName);
        String productPrice = driver.findElement(By.xpath("//*[text()='"+productName+"']//ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']")).getText();
        driver.findElement(By.xpath("//*[text()='"+productName+"']//ancestor::div[@class='inventory_item']//*[text()='Add to cart']")).click();

        log.info("Verifying presence of item '{}' in cart", productName);
        driver.get("https://www.saucedemo.com/cart.html");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='cart_item']//*[@class='inventory_item_name']")).getText(), productName, "Product Name in cart is incorrect");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='cart_item']//*[@class='inventory_item_price']")).getText(), productPrice, "Product Price in cart is incorrect");



    }
}