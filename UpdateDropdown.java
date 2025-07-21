import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateDropdown {

public static void main(String[] args) throws InterruptedException {
    
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.spicejet.com/");
    driver.manage().window().maximize();
    driver.findElement(By.xpath("//div[text()='Passengers']")).click();
    Thread.sleep(3000);

    System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText());
    int i = 1;
    while(i < 5)
    {
        driver.findElement(By.cssSelector("div[data-testid='Adult-testID-plus-one-cta']")).click();
        System.out.print("**********");
        i++;
    }
    System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText());


}
}
