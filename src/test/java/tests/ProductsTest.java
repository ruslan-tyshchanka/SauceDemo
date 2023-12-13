package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends  BaseTest {

    @Test(description = "Verify that item can be added in cart")
    public void addItemToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(
                productsPage.getTitle(),
                "Products",
                "User is not logged in or wrong page"
        );

        String productName = "Sauce Labs Fleece Jacket";

        productsPage.addItemToCart(productName);

        Assert.assertEquals(
                productsPage.verifyRemoveFromCartButton(productName),
                1,
                "Remove button is not displayed, item might not be in cart"
        );


    }

    @Test(description = "Verify that item can be removed from cart")
    public void removeItemFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(
                productsPage.getTitle(),
                "Products",
                "User is not logged in or wrong page"
        );

        String productName = "Sauce Labs Fleece Jacket";

        productsPage.addItemToCart(productName);

        Assert.assertEquals(
                productsPage.verifyRemoveFromCartButton(productName),
                1,
                "Remove button is not displayed, item might not be in cart"
        );

        productsPage.removeItemFromCart(productName);

        Assert.assertEquals(
                productsPage.verifyAddToCartButton(productName),
                1,
                "Remove button is still displayed, item might still be in cart"
        );
    }
}
