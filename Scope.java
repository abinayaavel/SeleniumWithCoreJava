package main;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // limitng the scope to footer from entire page of a tags
        System.out.println(driver.findElements(By.cssSelector("div[class*='footer'] a")).size());

        WebElement firstColumn = driver.findElement(By.cssSelector("div[class*='footer'] td:nth-child(1)"));

        for (int i = 1; i < firstColumn.findElements(By.tagName("a")).size(); i++) {
            String clickonLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            firstColumn.findElements(By.tagName("a")).get(i).sendKeys(clickonLinkTab);

            Thread.sleep(5000L);

        }

        // opens all the tabs
        Set<String> windows = driver.getWindowHandles();// 5
        Iterator<String> iterator = windows.iterator();

        while (iterator.hasNext()) {

            driver.switchTo().window(iterator.next());
            System.out.println(driver.getTitle());

        }
    }

}
