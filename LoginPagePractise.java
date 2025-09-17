package main;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPagePractise {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        LoginPagePractise loginPagePractise = new LoginPagePractise();
        loginPagePractise.loginToPage(driver);

    }

    public void loginToPage(WebDriver driver) throws InterruptedException {

        String userName = "rahulshettyacademy";
        String pswd = "learning";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(7000));

        driver.findElement(By.cssSelector("input#username")).sendKeys(userName);
        driver.findElement(By.cssSelector("input#password")).sendKeys(pswd);
        driver.findElement(By.cssSelector("input[value='user']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#okayBtn")));

        driver.findElement(By.cssSelector("#okayBtn")).click();

        Thread.sleep(3000);
        Select option = new Select(driver.findElement(By.cssSelector("select.form-control")));
        option.selectByValue("consult");

        // span.termsText
        driver.findElement(By.cssSelector("input#terms")).click();
        driver.findElement(By.cssSelector("input#signInBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkout")));

        List<WebElement> titles = new ArrayList<>();
        titles = driver.findElements(By.cssSelector("app-card-list.row div.card-body h4 a"));

        for (int i = 0; i < titles.size(); i++) {
            System.out.println(
                    driver.findElements(By.cssSelector("app-card-list.row div.card-body h4 a")).get(i).getText());
            driver.findElements(By.cssSelector("app-card-list.row div.card-footer button")).get(i)
                    .click();

        }

        driver.findElement(By.partialLinkText("Checkout")).click();

    }

}
