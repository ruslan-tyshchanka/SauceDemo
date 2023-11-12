import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocatorTest extends BaseTest{



    @Test
    public void addRemoveElements() {
        driver.get("https://www.saucedemo.com/index.html");
        driver.findElement(By.xpath("//button[text()=\"Add Element\"]")).click();
        boolean isElement1Displayed = driver.findElement(By.xpath("(//button[text()=\"Delete\"])[1]")).isDisplayed();
        Assert.assertTrue(isElement1Displayed);
        driver.findElement(By.xpath("//button[text()=\"Add Element\"]")).click();
        boolean isElement2Displayed = driver.findElement(By.xpath("(//button[text()=\"Delete\"])[2]")).isDisplayed();
        Assert.assertTrue(isElement2Displayed);
        driver.findElement(By.xpath("(//button[text()=\"Delete\"])[2]")).click();
        Assert.assertEquals(driver.findElements(By.xpath("//button[text()='Delete']")).size(), 1);
        driver.findElement(By.xpath("(//button[text()=\"Delete\"])[1]")).click();
        Assert.assertEquals(driver.findElements(By.xpath("//button[text()='Delete']")).size(), 0);
    }


}