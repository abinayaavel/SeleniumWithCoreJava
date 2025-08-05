package selenium;

import java.time.Month;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarTest {

    public static void main(String[] args) {

        String date = "28";
        String month = "05";
        String year = "2027";

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector("div.react-date-picker")).click();
        driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector("button.react-calendar__navigation__label")).click();

        By yearBy = By.cssSelector("button.react-calendar__decade-view__years__year");
        for (int i = 0; i < driver.findElements(yearBy).size(); i++) {
            if (driver.findElements(yearBy).get(i).getText().equals(year)) {

                driver.findElements(yearBy).get(i).click();
                break;
            }
        }

        By monthBy = By.cssSelector("button.react-calendar__year-view__months__month");
        for (int i = 0; i < driver.findElements(monthBy).size(); i++) {
            if (getNumberFromMonthName(driver.findElements(monthBy).get(i).getText()) == Integer.parseInt(month)) {
                driver.findElements(monthBy).get(i).click();
                break;
            }
        }

        By dateBy = By.cssSelector(
                "button[class*=react-calendar__month-view__days__day]:not([class*='neighboringMonth']) abbr");
        for (int i = 0; i < driver.findElements(dateBy).size(); i++) {
            if (driver.findElements(dateBy).get(i).getText().equals(date)) {
                driver.findElements(dateBy).get(i).click();
                break;
            }
        }

        // div[class*="calendar-day-"]:not([class*="unavailable"])

    }

    public static int getNumberFromMonthName(String monthName) {

        return Month.valueOf(monthName.toUpperCase()).getValue();
    }

}
