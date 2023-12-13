import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import  static org.testng.Assert.assertEquals;

@Log4j2
public class LoginTest extends BaseTest {

    @Test
    public void successfulLogin() {
        log.info("Logging in with valid credentials");
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String title = driver.findElement(By.cssSelector(".title")).getText();
        assertEquals(title, "Products", "User is not logged in or wrong page");
    }

    @Test
    public void loginWithoutName() {
        log.info("Logging in without a name");
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String error = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        assertEquals(error, "Epic sadface: Username is required", "User is logged in without name or wrong error message");
    }

    @Test
    public void loginWithoutPassword() {
        log.info("Loggin in without a password");
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("login-button")).click();
        String error = driver.findElement(By.cssSelector("[data-test='error']")).getText();
        assertEquals(error, "Epic sadface: Password is required", "User is logged in without password or wrong error message");
    }

}
