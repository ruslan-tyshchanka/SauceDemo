import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LocatorTest extends BaseTest{

    @Test
    public void findLocators() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("login_button_container"));
        driver.findElement(By.name("login-button"));
        driver.findElement(By.className("login-box"));
        driver.findElements(By.tagName("autocorrect"));

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String title = driver.findElement(By.cssSelector(".title")).getText();
        assertEquals(title, "Products", "User is not logged in or wrong page");

        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElements(By.linkText("https://saucelabs.com/"));
        driver.findElements(By.partialLinkText("saucelabs"));

        driver.findElement(By.xpath("//*[@data-test='add-to-cart-sauce-labs-backpack']"));
        driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
        driver.findElement(By.xpath("//*[contains(@class, 'btn_inventory')]"));
        driver.findElement(By.xpath("//*[contains(text(), 'Backpack')]"));
        driver.findElement(By.xpath("//*[contains(text(), 'Backpack')]//ancestor::div[contains(@class, 'description')]"));
        driver.findElement(By.xpath("//*[contains(text(), 'Backpack')]//parent::*"));
        driver.findElement(By.xpath("//*[contains(text(), 'T-Shirt')]//ancestor::div[@class='inventory_item']/following::*"));
        driver.findElement(By.xpath("//*[contains(text(), 'T-Shirt')]//ancestor::div[@class='inventory_item']/preceding::*"));
        driver.findElement(By.xpath("//*[contains(text(), 'T-Shirt') and @class]"));

        driver.findElements(By.cssSelector("inventory_item"));
        driver.findElement(By.cssSelector(".inventory_item .inventory_item_description"));
        driver.findElements(By.cssSelector(".btn_primary.btn_small"));
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        driver.findElement(By.cssSelector("select"));
        driver.findElement(By.cssSelector("select.product_sort_container"));
        driver.findElement(By.cssSelector("[data-test='product_sort_container']"));
        driver.findElements(By.cssSelector("[data-test~='container']"));
        driver.findElements(By.cssSelector("[data-test|='product']"));
        driver.findElement(By.cssSelector("select[data-test^='product_']"));
        driver.findElement(By.cssSelector("select[data-test$='container']"));
        driver.findElement(By.cssSelector("select[data-test*='_sort_']"));


    }


}