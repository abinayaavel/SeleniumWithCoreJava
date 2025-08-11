package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JseAssignment {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600)");
        Thread.sleep(2000);

        js.executeScript("document.querySelector(\"table[name='courses']\")");

        List<WebElement> tableRows = driver.findElements(By.cssSelector("table[name='courses'] tr"));
        System.out.println(tableRows.size() + " ==== Row size");

        List<WebElement> tableColumns = driver.findElements(By.cssSelector("table[name='courses'] tr th"));
        System.out.println(tableColumns.size() + " ==== Column size");

        List<WebElement> secondRowValues = driver
                .findElements(By.cssSelector("table[name='courses'] tr:nth-child(3) td"));

        for (int i = 0; i < secondRowValues.size(); i++) {
            System.out.println(secondRowValues.get(i).getText() + " ==== SecondRowValues");

        }

    }

}
