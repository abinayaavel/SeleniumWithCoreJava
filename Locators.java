package main;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators {

    public static void main(String[] args) throws InterruptedException {

        // WebDriver driver = new ChromeDriver();

        // WebDriver driver = new FirefoxDriver();
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("hello123");
        driver.findElement(By.cssSelector("button.signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText() + " *********** ");

        driver.findElement(By.linkText("Forgot your password?")).click();
        // Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("john");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john.yaa7489@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("8590899990");

        driver.findElement(By.className("reset-pwd-btn")).click();
        // System.out.println(driver.findElement(By.className("infoMsg")).getText() + "
        // reset login message");

        System.out.println(driver.findElement(By.cssSelector("form p")).getText() + " reset login message");
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        // driver.quit();
    }
}
