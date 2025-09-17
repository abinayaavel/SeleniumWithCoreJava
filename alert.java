package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alert {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        String text = "Krithvik";
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        driver.findElement(By.cssSelector("input#name")).sendKeys(text);

        driver.findElement(By.cssSelector("input#alertbtn")).click();

        System.out.println(driver.switchTo().alert().getText() + " ***********");
        driver.switchTo().alert().accept();

        driver.findElement(By.cssSelector("input#confirmbtn")).click();
        driver.switchTo().alert().dismiss();
    }

}
