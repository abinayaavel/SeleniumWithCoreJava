package main;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class windowHandles {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector("a.blinkingText")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentID = iterator.next();
        String childID = iterator.next();
        driver.switchTo().window(childID);

        String userMailID = driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim()
                .split(" ")[0];

        driver.switchTo().window(parentID);
        driver.findElement(By.cssSelector("input#username")).sendKeys(userMailID);

    }

}
