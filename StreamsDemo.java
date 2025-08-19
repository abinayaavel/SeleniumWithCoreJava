package selenium;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamsDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        List<WebElement> webElementList = driver
                .findElements(By.cssSelector("table.table-bordered tbody tr td:nth-child(1)"));
        List<String> originalList = webElementList.stream().map(s -> s.getText()).collect(Collectors.toList());

        driver.findElement(By.cssSelector("table.table-bordered tr th:first-child")).click();
        List<WebElement> sortedElementsList = driver
                .findElements(By.cssSelector("table.table-bordered tbody tr td:nth-child(1)"));
        List<String> sortedList = sortedElementsList.stream().map(s -> s.getText()).collect(Collectors.toList());

        // originalList.stream().sorted().forEach(s -> System.out.println(s + " ===
        // original sorted list"));
        // sortedList.stream().sorted().forEach(s -> System.out.println(s + " === sorted
        // sorted list"));

        Assert.assertEquals(originalList.stream().sorted(), sortedList.stream().sorted());

    }

}
