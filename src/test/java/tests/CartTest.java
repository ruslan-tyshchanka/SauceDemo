package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "Check that cart can be opened")
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

    @Test(description = "Add and remove product item in Cart")
    public void getElementInCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(
                productsPage.getTitle(),
                "Products",
                "User is not logged in or wrong page"
        );

        String productName = "Sauce Labs Backpack";

        productsPage.addItemToCart(productName);

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
