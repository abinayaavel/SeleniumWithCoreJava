package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--disable-infobars");
        options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

        WebElement moveElement = driver.findElement(By.cssSelector("#nav-link-accountList"));

        Actions actions = new Actions(driver);
        actions.moveToElement(moveElement).build().perform();

        /*
         * if
         * (driver.findElement(By.cssSelector("input#twotabsearchtextbox")).isDisplayed(
         * ) == false) {
         * 
         * driver.findElement(By.linkText("Continue shopping")).click();
         * 
         * }
         */
        actions.moveToElement(driver.findElement(By.cssSelector("input#twotabsearchtextbox"))).click()
                .keyDown(Keys.SHIFT)
                .sendKeys("hello").build().perform();
        actions.moveToElement(moveElement).contextClick().build().perform();

    }

}
