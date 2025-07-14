import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Corrected URL
        driver.get("https://www.youtube.com");

        // Wait until the search box is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search_query")));

        // Send keys to search box
        searchBox.sendKeys("movies");

        WebElement searchBtn = driver.findElement(By.className("ytSearchboxComponentSearchButton"));
        searchBtn.click();
        // Optional: pause to see the result
        Thread.sleep(3000);

        driver.quit();
    }
}
