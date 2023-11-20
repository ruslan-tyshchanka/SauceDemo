package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void openCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(
                productsPage.getTitle(),
                "Products",
                "User is not logged in or wrong page"
        );

        cartPage.open();
    }

    @Test
    public void getElementInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(
                productsPage.getTitle(),
                "Products",
                "User is not logged in or wrong page"
        );

        String productName = "Sauce Labs Fleece Jacket";

        productsPage.addItemToCart("Sauce Labs Fleece Jacket");

        cartPage.open();
        Assert.assertEquals(
                cartPage.getItemInCart(productName),
                1,
                "Item is not in cart"
        );
        cartPage.removeElementFromCart(productName);
        Assert.assertEquals(
                cartPage.getItemInCart(productName),
                0,
                "Item is still in cart"
        );
    }
}