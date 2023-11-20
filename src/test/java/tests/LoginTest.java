package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import  static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(
                productsPage.getTitle(),
                "Products",
                "User is not logged in or wrong page"
        );
    }

    @Test
    public void loginWithoutName() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(
                loginPage.verifyErrorMessage(),
                "Epic sadface: Username is required",
                "User is logged in without usernam or wrong error message"
        );    }

    @Test
    public void loginWithoutPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(
                loginPage.verifyErrorMessage(),
                "Epic sadface: Password is required",
                "User is logged in without password or wrong error message"
        );
    }

}
