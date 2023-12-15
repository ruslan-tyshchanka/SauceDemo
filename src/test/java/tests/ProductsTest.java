package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Log4j2
public class ProductsTest extends  BaseTest {

    @Test(description = "Verify that item can be added in cart")
    public void addItemToCart() {
        log.info("Logging in with valid credentials");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(
                productsPage.getTitle(),
                "Products",
                "User is not logged in or wrong page"
        );

        String productName = "Sauce Labs Fleece Jacket";

        log.info("Add item '{}' to cart", productName);
        productsPage.addItemToCart(productName);

        Assert.assertEquals(
                productsPage.verifyRemoveFromCartButton(productName),
                1,
                "Remove button is not displayed, item might not be in cart"
        );


    }

    @Test(description = "Verify that item can be removed from cart")
    public void removeItemFromCart() {
        log.info("Logging in with valid credentials");

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(
                productsPage.getTitle(),
                "Products",
                "User is not logged in or wrong page"
        );

        String productName = "Sauce Labs Fleece Jacket";

        log.info("Add item '{}' to cart", productName);
        productsPage.addItemToCart(productName);

        Assert.assertEquals(
                productsPage.verifyRemoveFromCartButton(productName),
                1,
                "Remove button is not displayed, item might not be in cart"
        );

        log.info("Removing item '{}' from the cart", productName);
        productsPage.removeItemFromCart(productName);

        Assert.assertEquals(
                productsPage.verifyAddToCartButton(productName),
                1,
                "Remove button is still displayed, item might still be in cart"
        );
    }
}
