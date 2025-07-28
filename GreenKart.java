package selenium;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKart {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        String[] itemsNeeded = { "Pomegranate", "Cauliflower", "Brinjal" };
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(2000);

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
    }

}
