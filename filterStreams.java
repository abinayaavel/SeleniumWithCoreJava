package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class filterStreams {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("null");
        driver.findElement(By.id("search-field")).sendKeys("Rice");

        List<WebElement> searchedList = driver
                .findElements(By.cssSelector("table.table-bordered tbody tr td:nth-child(1)"));
    }

}
