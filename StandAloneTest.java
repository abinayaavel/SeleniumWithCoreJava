package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StandAloneTest {

        public static void main(String[] args) {

                String productName = "iphone 13 pro";
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.get("https://rahulshettyacademy.com/client");

                driver.findElement(By.id("userEmail")).sendKeys("bankingaspirant2805@gmail.com");
                driver.findElement(By.id("userPassword")).sendKeys("Santhu@280592");
                driver.findElement(By.id("login")).click();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
                List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
                WebElement prod = products.stream()
                                .filter(product -> product.findElement(By.cssSelector("b")).getText()
                                                .equalsIgnoreCase(productName))
                                .findFirst().orElse(null);
                prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
                wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));

                driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();
                List<WebElement> cartProductList = driver.findElements(By.cssSelector(".cartSection h3"));
                boolean match = cartProductList.stream()
                                .anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));

                System.out.println(match + " ======= >>>>>>>>>> ");
                Assert.assertTrue(match, " Product selected successfully");

                driver.findElement(By.cssSelector(".totalRow button")).click();
                driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("ind");
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

                /*
                 * List<WebElement> items = driver.findElements(By.cssSelector(".ta-item"));
                 * items.stream().filter(item -> item.getText().equalsIgnoreCase("india"))
                 */

                driver.quit();

        }

}