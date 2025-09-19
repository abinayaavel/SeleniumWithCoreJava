package main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {

    WebDriver driver;

    public ProductCatalog(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    By productsElement = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");
    By blinkBy = By.cssSelector(".ng-animating");

    public List<WebElement> getProductList() {
        waitForElementToAppear(productsElement);
        return products;
    }

    public WebElement getProductName(String productName) {
        WebElement prod = getProductList().stream()
                .filter(product -> product.findElement(By.cssSelector("b")).getText()
                        .equalsIgnoreCase(productName))
                .findFirst().orElse(null);
        return prod;

    }

    public void addProductToCart(String productName) {
        WebElement prod = getProductName(productName);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        waitForElementToAppear(toastMessage);
        waitForElementToDisappear(blinkBy);

    }

}
