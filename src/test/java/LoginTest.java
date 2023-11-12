import org.openqa.selenium.By;
import org.testng.annotations.Test;
import  static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String title = driver.findElement(By.cssSelector(".title")).getText();
        assertEquals(title, "Products", "User is not logged in or wrong page");
    }

    @Test
    public void loginWithoutName() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String error = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        assertEquals(error, "Epic sadface: Username is required", "User is logged in without name or wrong error message");
    }

    @Test
    public void loginWithoutPassword() {
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("login-button")).click();
        String error = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        assertEquals(error, "Epic sadface: Password is required", "User is logged in without password or wrong error message");
    }

}
