package pl.testeroprogramowania.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pl.testeroprogramowania.utils.SeleniumHelper;

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
}
