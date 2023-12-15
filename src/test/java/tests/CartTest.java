package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class CartTest extends BaseTest {

    @Test(description = "Check that cart can be opened")
    public void openCart() {
        log.info("Logging in with valid credentials");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(
                productsPage.getTitle(),
                "Products",
                "User is not logged in or wrong page"
        );

        log.info("Opening cart");
        cartPage.open();
    }

    @Test(description = "Add and remove product item in Cart")
    public void getElementInCart() {
        log.info("Logging in with valid credentials");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(
                productsPage.getTitle(),
                "Products",
                "User is not logged in or wrong page"
        );

        String productName = "Sauce Labs Backpack";

        log.info("Add item '{}' to cart", productName);
        productsPage.addItemToCart(productName);

        log.info("Open a cart");
        cartPage.open();
        Assert.assertEquals(
                cartPage.getItemInCart(productName),
                1,
                "Item is not in cart"
        );
        log.info("Remove item '{}' from cart", productName);
        cartPage.removeElementFromCart(productName);
        Assert.assertEquals(
                cartPage.getItemInCart(productName),
                0,
                "Item is still in cart"
        );
    }
}
