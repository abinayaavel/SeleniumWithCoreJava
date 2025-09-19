package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class SubmitOrderPage extends AbstractComponent {

    WebDriver driver;

    public SubmitOrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = "input[placeholder='Select Country']")
    WebElement countrySelection;

    @FindBy(css = "button[class*='ta-item']:nth-of-type(2)")
    WebElement countrySelectionFromDropDown;

    @FindBy(css = ".action__submit")
    WebElement submitButton;

    By countryDropdown = By.cssSelector(".ta-results");

    public void selectCountry(String country) {

        countrySelection.sendKeys(country);
        waitForElementToAppear(countryDropdown);
        countrySelectionFromDropDown.click();
    }

    public OrderDetailsPage clickOnSubmitBtn() {
        submitButton.click();
        OrderDetailsPage orderDetailsPage = new OrderDetailsPage(driver);
        return orderDetailsPage;
    }

}
