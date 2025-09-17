package main;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class childParentAssignment {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Multiple Windows")).click();

        driver.findElement(By.cssSelector("div.example a")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        System.out
                .println(driver.switchTo().window(childWindow).findElement(By.cssSelector("div.example h3")).getText());
        System.out.println(
                driver.switchTo().window(parentWindow).findElement(By.cssSelector("div.example h3")).getText());

    }

}
