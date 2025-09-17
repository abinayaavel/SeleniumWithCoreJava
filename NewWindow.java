package main;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {

        public static void main(String[] args) throws IOException {

                WebDriver driver = new ChromeDriver();
                driver.get("https://rahulshettyacademy.com/angularpractice/");
                driver.switchTo().newWindow(WindowType.TAB);

                Set<String> windowHandles = driver.getWindowHandles();
                Iterator<String> iterator = windowHandles.iterator();
                String parentWindow = iterator.next();
                String childWindow = iterator.next();

                driver.switchTo().window(childWindow);
                driver.get("https://rahulshettyacademy.com/");

                String courseName = driver
                                .findElements(By.cssSelector(
                                                "div.courses-block a[href*='https://courses.rahulshettyacademy.com/']"))
                                .get(1).getText();
                driver.switchTo().window(parentWindow);
                WebElement ssElement = driver.findElement(By.cssSelector("input.form-control[name='name']"));
                ssElement.sendKeys(courseName);
                File file = ssElement.getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(file,
                                new File("C:\\Users\\Admin\\Desktop\\selenium-java\\seleniumIntro\\src\\screenshots\\logo.png"));
                System.out.println(
                                ssElement.getRect().getDimension().getHeight() + " ---- "
                                                + ssElement.getRect().getDimension().getWidth());
                driver.quit();

        }

}
