package pl.testeroprogramowania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.testeroprogramowania.models.Customer;

public class AdressDetailsPage {

    @FindBy(id = "billing_first_name")
    private WebElement firstNameInput;

    @FindBy(id = "billing_last_name")
    private WebElement lastNameInput;

    @FindBy(id = "billing_company")
    private WebElement companyNameInput;

    @FindBy(id = "billing_country")
    private WebElement billingCountrySelect;

    @FindBy(id = "billing_address_1")
    private WebElement billingAddressInput;

    @FindBy(id = "billing_postcode")
    private WebElement billingPostCodeInput;

    @FindBy(id = "billing_city")
    private WebElement billingCityInput;

    @FindBy(id = "billing_phone")
    private WebElement billingPhoneInput;

    @FindBy(id = "billing_email")
    private WebElement billingEmailInput;

    @FindBy(id = "order_comments")
    private WebElement orderCommentsInput;

    @FindBy(id = "place_order")
    private WebElement placeOrderButton;

    private WebDriver driver;

    public AdressDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public AdressDetailsPage fillAddressDetails(Customer customer, String comments) {
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        companyNameInput.sendKeys(customer.getCompanyName());
        Select countrySelect = new Select(billingCountrySelect);
        countrySelect.selectByVisibleText(customer.getCountry());
        billingAddressInput.sendKeys(String.format("%s %s", customer.getStreet(), customer.getFlatNumber()));
        billingPostCodeInput.sendKeys(customer.getZipCode());
        billingCityInput.sendKeys(customer.getCity());
        billingPhoneInput.sendKeys(customer.getPhone());
        billingEmailInput.sendKeys(customer.getEmail());
        orderCommentsInput.sendKeys(comments);
        return this;
    }

    public OrderDetailsPage clickOrderButtonWithoutEx(){
        try {
            placeOrderButton.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            placeOrderButton.click();
        }
        return new OrderDetailsPage(driver);
    }
}
