package main;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sampleTutorialpoints {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

        clickOnMainSection(driver, "div h2#headingOne");
        clickOnDropDownSection(driver, "Login");

    }

    private static void clickOnMainSection(WebDriver driver, String inputElement) {

        if (!driver.findElement(By.cssSelector(inputElement + " + div.show")).isEnabled()) {
            driver.findElement(By.cssSelector(inputElement)).click();

        }

    }

    private static void clickOnDropDownSection(WebDriver driver, String visibleText) {

        List<WebElement> dropdownListElements = driver.findElements(By.cssSelector("div.show div ul li"));

        for (WebElement dropdoWebElement : dropdownListElements) {
            if (dropdoWebElement.getText().contains(visibleText))
                dropdoWebElement.click();
        }

    }

}
