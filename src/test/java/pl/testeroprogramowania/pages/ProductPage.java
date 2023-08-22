package pl.testeroprogramowania.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    private WebDriver driver;

    @FindBy(name = "add-to-cart")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='woocommerce-message']//a[text()='View cart']")
    private WebElement viewCartButton;

    private static final Logger logger = LogManager.getLogger();

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public ProductPage addProductToCart() {
        logger.info("Adding product to cart");
        addToCartButton.click();
        logger.info("Adding product to cart done");
        return this;
    }
    public CartPage viewCart (){
        viewCartButton.click();
        return new CartPage(driver);
    }
}
