import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxSelection {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        Assert.assertFalse(driver.findElement(By.cssSelector("input[name*=friendsandfamily]")).isSelected());

        driver.findElement(By.cssSelector("input[name*=friendsandfamily]")).click();;
        Thread.sleep(3000);

        Assert.assertTrue(driver.findElement(By.cssSelector("input[name*=friendsandfamily]")).isSelected());

        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

    
    }
    
}
