package main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        Thread.sleep(2000);
        js.executeScript("document.querySelector('div.tableFixHead').scrollTop=500");

        List<WebElement> amountValues = driver.findElements(By.cssSelector("div.tableFixHead td:nth-child(4)"));
        Integer sum = 0;

        for (int i = 0; i < amountValues.size(); i++) {
            sum += Integer.parseInt(amountValues.get(i).getText());
        }

        Assert.assertEquals(driver.findElement(By.cssSelector("div.totalAmount")).getText().split(":")[1].trim(),
                sum.toString());
    }

}
