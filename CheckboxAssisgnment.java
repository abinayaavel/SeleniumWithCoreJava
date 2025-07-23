import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxAssisgnment {

    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String cssSelector_checkBox = "#checkBoxOption1";

        Assert.assertFalse(driver.findElement(By.cssSelector(cssSelector_checkBox)).isSelected());
        driver.findElement(By.cssSelector(cssSelector_checkBox)).click();
        Assert.assertTrue(driver.findElement(By.cssSelector(cssSelector_checkBox)).isSelected());

        driver.findElement(By.cssSelector(cssSelector_checkBox)).click();
        Assert.assertFalse(driver.findElement(By.cssSelector(cssSelector_checkBox)).isSelected());


        // Count the no of Checkboxes

        List<WebElement> countOfCheckboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        System.out.println("There are "+countOfCheckboxes.size() +" checkboxes in this webpage");



       
    }
    
}
