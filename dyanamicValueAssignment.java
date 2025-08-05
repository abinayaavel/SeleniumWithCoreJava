package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class dyanamicValueAssignment {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement optionTobeSelecWebElement = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
        String optionSelected = "";
        optionTobeSelecWebElement.click();

        if (optionTobeSelecWebElement.isSelected()) {
            optionSelected = driver.findElement(By.xpath("//input[@id='checkBoxOption1']/parent::label")).getText();
        }

        Select dropdown = new Select(driver.findElement(By.cssSelector("#dropdown-class-example")));
        dropdown.selectByVisibleText(optionSelected);

        driver.findElement(By.cssSelector("input#name")).sendKeys(optionSelected);
        driver.findElement(By.cssSelector("input#alertbtn")).click();

        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertTrue(alertMessage.contains(optionSelected));

    }

}
