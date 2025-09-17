package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;

public class UILocatorsAssignment {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();

        driver.findElement(By.name("name")).sendKeys("Daya");
        driver.findElement(By.name("email")).sendKeys("daya.kiki15@yahoo.com");
        driver.findElement(By.cssSelector("input#exampleInputPassword1")).sendKeys("gayu23071990");
        driver.findElement(By.cssSelector("input#exampleCheck1")).click();

        Select option = new Select(driver.findElement(By.cssSelector("#exampleFormControlSelect1")));
        option.selectByVisibleText("Female");

        driver.findElement(By.cssSelector("input#inlineRadio2")).click();
        driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("24-10-2025");

        driver.findElement(By.cssSelector("input[value='Submit']")).click();
        System.out.println(
                driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText());
    }
}
