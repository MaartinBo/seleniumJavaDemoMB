package pl.testeroprogramowania.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pl.testeroprogramowania.utils.SeleniumHelper;

import java.text.DecimalFormat;
import java.util.List;

public class ProductListPage {

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public ProductPage openProduct(String title){
        logger.info("Opening product");
        By productXpath = By.xpath("//h2[text()='"+ title+"']");
        SeleniumHelper.waitForClickable(productXpath, driver);
        driver.findElement(productXpath).click();
        logger.info("Opening product done");
        return new ProductPage(driver);
    }

    public ProductListPage validateProductActualPrice(String product, Float expectedPrice) {
        logger.info("Validating product actual price");

        // Build the XPath expression to locate the product price
        String xpathExpressionPrice = "//h2[text()='"+ product +"']/ancestor::li//span[@class='woocommerce-Price-amount amount']";

        float floatValue = expectedPrice;
        // Format the float as "9,99 from 9.99
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String formattedExpectedPriceValue = decimalFormat.format(floatValue);

        By productPriceXpath = By.xpath(xpathExpressionPrice);

        // Find the WebElement using the XPath
        List<WebElement> productPriceElements = driver.findElements(productPriceXpath);

        if (productPriceElements.size() > 1) {
            // Handle the case when there are multiple matching elements, if there are multiple elements that means the product has discount
            // so the second element is equal to actual price
            WebElement productPriceElement = productPriceElements.get(1);
            String actualPrice = productPriceElement.getText();
            String actualPriceTrimmed = actualPrice.replace(" zł", "");

            Assert.assertEquals(actualPriceTrimmed, formattedExpectedPriceValue);
        } else if (productPriceElements.size() == 1) {
            WebElement productPriceElement = productPriceElements.get(0);
            String actualPrice = productPriceElement.getText();

            String actualPriceTrimmed = actualPrice.replace(" zł", "");

            Assert.assertEquals(actualPriceTrimmed, formattedExpectedPriceValue);
        } else {
            System.out.println("No matching element found with the price of " + product);
        }
        logger.info("Validating product actual price done");
        return this;
    }
}
