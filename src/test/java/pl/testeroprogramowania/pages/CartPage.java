package pl.testeroprogramowania.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.testeroprogramowania.utils.SeleniumHelper;

public class CartPage {

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    @FindBy(partialLinkText = "Proceed to checkout")
    private WebElement proceedToCheckoutButton;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public AdressDetailsPage openAddressDetails(){
        logger.info("Opening AddressDetailsPage");
        SeleniumHelper.waitForClickable(proceedToCheckoutButton,driver);
        proceedToCheckoutButton.click();
        logger.info("Opening AddressDetailsPage done");
        return new AdressDetailsPage(driver);
    }
}
