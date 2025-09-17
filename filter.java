package main;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class filter {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.id("search-field")).sendKeys("rice");
        List<WebElement> veggies = driver.findElements(By.cssSelector("tr td:nth-child(1)"));
        List<WebElement> filteredList = veggies.stream().filter(veggie -> veggie.getText().contains("Rice"))
                .collect(Collectors.toList());

        veggies.forEach(s -> System.out.println(s.getText() + " ======= veggies"));
        filteredList.forEach(s -> System.out.println(s.getText() + " ===== filteredList"));

        Assert.assertEquals(veggies.size(), filteredList.size());
    }

}
