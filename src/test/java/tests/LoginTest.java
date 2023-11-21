package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import  static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(description = "Login with valid credentials")
    public void successfulLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(
                productsPage.getTitle(),
                "Products",
                "User is not logged in or wrong page"
        );
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }

    @Test(dataProvider = "loginData", description = "Try to login without name")
    public void loginWithoutName(String user, String password, String expectedError) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(
                loginPage.verifyErrorMessage(),
                expectedError,
                "User is logged in without username or wrong error message"
        );    }

    @Test(description = "Try to login without password")
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
