package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl= "https://courses.ultimateqa.com/";


    @Before
    public void setup() {
        OpenBrowers(baseUrl);

    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        String expectedMessage = "Welcome Back!";
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//h1[text()='Welcome Back!']"));
        String actualMessage = actualTextMessageElement.getText();
        Assert.assertEquals("Verify the text", expectedMessage, actualMessage);

    }
    @Test
    public void verifyTheErrorMessage(){
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        driver.findElement(By.id("user[email]")).sendKeys("pradippraidp");
        driver.findElement(By.id("user[password]")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        String expectedMessage = "Invalid email or password.";
        WebElement actualTextMessageElement = driver.findElement(By.xpath("//div[@id='notice']/ul/li"));
        String actualMessage = actualTextMessageElement.getText();
        Assert.assertEquals("Verify the text", expectedMessage, actualMessage);


    }
    @After
    public void setdown(){
        closeBrowser();

    }
}
