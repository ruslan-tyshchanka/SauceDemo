package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class LoginPage extends BasePage {

    private final By USERNAME_INPUT = By.id("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test='error']");

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    @Step("Open login page")
    public void open() {
        driver.get("https://www.saucedemo.com");
    }

    @Step("Login by {user}")
    public void login(String user, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        takeScreenshot(driver);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Attachment(value = "screenshot", type = "image/png")
    private static byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public String verifyErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

}
