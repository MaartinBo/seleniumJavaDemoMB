package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage {

    @FindBy(xpath = "//div[@class='woocommerce-order']//p")
    public WebElement orderNotice;

    @FindBy(xpath = "//td[contains(@class, 'product-name')]")
    private WebElement productName;

    public OrderDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getOrderNotice() {
        return orderNotice;
    }
}
