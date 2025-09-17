package main;

//import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class mouseHoverAssign {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("input#autocomplete")).sendKeys("uni");

        Thread.sleep(3000);

        for (int i = 0; i < 5; i++)
            driver.findElement(By.cssSelector("input#autocomplete")).sendKeys(Keys.DOWN);

        System.out.println(driver.findElement(By.cssSelector("input#autocomplete")).getAttribute("value"));

    }

}
