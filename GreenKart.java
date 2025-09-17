package main;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GreenKart {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        String[] itemsNeeded = { "Pomegranate", "Cauliflower", "Brinjal" };
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        List<WebElement> productList = driver.findElements(By.cssSelector("h4[class='product-name']"));
        int j = 0;
        for (int i = 0; i < productList.size(); i++) {
            String name = productList.get(i).getText().split("-")[0].trim();
            List<String> itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(name)) {

                driver.findElement(By
                        .xpath("//h4[contains(text(),'" + name + "')]/parent::div/div[@class='product-action']/button"))
                        .click();
                j++;

                if (j > itemsNeededList.size()) {
                    break;
                }
            }
        }

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.cssSelector("div[class='cart-preview active'] button[type='button']")).click();
        driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("span.promoInfo")).getText(), "Code applied ..!");

        driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();

    }

}
