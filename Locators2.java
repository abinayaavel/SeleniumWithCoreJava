package main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String name = "abi";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        String password = getPassword(driver);
        driver.findElement(By.className("go-to-login-btn")).click();

        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(password);
        driver.findElement(By.cssSelector("button.signInBtn")).click();
        Thread.sleep(1000);

        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");

        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
                "Hello " + name + ",");
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        driver.close();

    }

    public static String getPassword(WebDriver driver) throws InterruptedException

    {
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("reset-pwd-btn")).click();

        String password = driver.findElement(By.cssSelector("form p")).getText().split("'")[1].split("'")[0];
        return password;

    }

}
