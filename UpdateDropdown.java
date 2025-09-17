package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdateDropdown {

        public static void main(String[] args) throws InterruptedException {

                WebDriver driver = new ChromeDriver();
                driver.get("https://www.spicejet.com/");
                driver.manage().window().maximize();
                driver.findElement(By.xpath("//div[text()='Passengers']")).click();
                Thread.sleep(3000);

                System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText());
                int i = 1;
                while (i < 5) {
                        driver.findElement(By.cssSelector("div[data-testid='Adult-testID-plus-one-cta']")).click();
                        i++;
                }
                System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText());

                driver.findElement(
                                By.cssSelector("div[data-testid='round-trip-radio-button']  > div:nth-child(2) > div"))
                                .click();

                System.out.println(driver
                                .findElement(By.cssSelector(
                                                "div[data-testid='return-date-dropdown-label-test-id'] > div:nth-child(1)"))
                                .getDomAttribute("style").contains("1") + "");
                Assert.assertTrue(driver
                                .findElement(By.cssSelector(
                                                "div[data-testid='return-date-dropdown-label-test-id'] > div:nth-child(1)"))
                                .getDomAttribute("style").contains("1"), " return date disabled");

                driver.findElement(By.cssSelector("div[data-testid='one-way-radio-button']  > div:nth-child(2) > div"))
                                .click();

                System.out.println(driver
                                .findElement(By.cssSelector(
                                                "div[data-testid='return-date-dropdown-label-test-id'] > div:nth-child(1)"))
                                .getDomAttribute("style") + " %%%%%%%%%%%%%%%%%%%%%%");
                Assert.assertFalse(driver
                                .findElement(By.cssSelector(
                                                "div[data-testid='return-date-dropdown-label-test-id'] > div:nth-child(1)"))
                                .getDomAttribute("style").contains("1"), " return date enabled");

        }
}
