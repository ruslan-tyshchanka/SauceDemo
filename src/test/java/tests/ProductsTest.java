package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends  BaseTest {

    @Test(description = "Verify presence of specific product and its attributes in cart")
    public void verifyProductAttributesInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(
                productsPage.getTitle(),
                "Products",
                "User is not logged in or wrong page"
        );

        String productName = "Sauce Labs Fleece Jacket";

        productsPage.addItemToCart("Sauce Labs Fleece Jacket");

        productsPage.openCart();
        Assert.assertEquals(
                productsPage.getTitle(),
                "Your Cart",
                "Cart is not opened"
        );
        //driver.get("https://www.saucedemo.com/cart.html");
        //Assert.assertEquals(driver.findElement(By.xpath("//*[@class='cart_item']//*[@class='inventory_item_name']")).getText(), productName, "Product Name in cart is incorrect");



    }
}
