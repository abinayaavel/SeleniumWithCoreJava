package main;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = ".cartSection h3")
    List<WebElement> cartProductList;

    @FindBy(css = ".totalRow button")
    WebElement checkOutElement;

    public boolean verifyProductDisplay(String productName) {

        boolean match = cartProductList.stream()
                .anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }

    public SubmitOrderPage clickOnCheckOut() {
        checkOutElement.click();
        SubmitOrderPage submitOrderPage = new SubmitOrderPage(driver);
        return submitOrderPage;
    }

}
