package pl.testeroprogramowania.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//span[text()='My account']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//span[text()='Shop']")
    private WebElement shopLink;

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public MyAccountPage openMyAccountPage() {
        logger.info("Opening MyAccountPage");
        myAccountLink.click();
        logger.info("Opening MyAccountPage done");
        return new MyAccountPage(driver);
    }

    public ProductListPage openShopPage() {
        logger.info("Opening ShopPage");
        shopLink.click();
        logger.info("Opening ShopPage done");
        return new ProductListPage(driver);
    }
}
