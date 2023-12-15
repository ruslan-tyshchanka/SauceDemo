package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import  static org.testng.Assert.assertEquals;

@Log4j2
public class LoginTest extends BaseTest {

    @Test(description = "Login with valid credentials")
    public void successfulLogin() {
        log.info("Logging in with valid credentials");
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
        log.info("Logging in without credentials");
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }

    @Test(dataProvider = "loginData", description = "Try to login without credentials")
    public void loginWithoutName(String user, String password, String expectedError) {
        log.info("Logging in without a name");
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(
                loginPage.verifyErrorMessage(),
                expectedError,
                "User is logged in without username or wrong error message"
        );    }

    @Test(description = "Try to login without password")
    public void loginWithoutPassword() {
        log.info("Logging in without a password");
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(
                loginPage.verifyErrorMessage(),
                "Epic sadface: Password is required",
                "User is logged in without password or wrong error message"
        );
    }

}
