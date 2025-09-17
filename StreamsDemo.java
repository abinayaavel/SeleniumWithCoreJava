package main;

import java.util.List;
//import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class StreamsDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        String vegOrFruitString = "Rice";
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

        SoftAssert aSoftAssert = new SoftAssert();
        aSoftAssert.assertEquals(originalList.stream().sorted(),
                sortedList.stream().sorted());

        List<String> price;
        List<String> dPrice;

        do {

            List<WebElement> nextPageElementsList = driver
                    .findElements(By.cssSelector("table.table-bordered tbody tr td:nth-child(1)"));
            price = nextPageElementsList.stream().filter(s -> s.getText().contains(vegOrFruitString))
                    .map(s -> getPriceVeggie(s)).collect(Collectors.toList());

            dPrice = nextPageElementsList.stream().filter(s -> s.getText().contains(vegOrFruitString))
                    .map(s -> getDiscountPriceVeggie(s)).collect(Collectors.toList());

            if (price.size() < 1) {
                driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
            }

            price.forEach(s -> System.out.println(s + " price of " + vegOrFruitString));
            dPrice.forEach(s -> System.out.println(s + " discount price of " + vegOrFruitString));
        } while (price.size() < 1);

        aSoftAssert.assertAll("Original Vs Sorted");
    }

    private static String getDiscountPriceVeggie(WebElement s) {
        String dPrice = s.findElement(By.xpath("following-sibling::td[2]")).getText();
        return dPrice;
    }

    private static String getPriceVeggie(WebElement s) {

        String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return price;

    }

}
