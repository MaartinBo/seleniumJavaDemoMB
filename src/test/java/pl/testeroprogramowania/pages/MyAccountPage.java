package pl.testeroprogramowania.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    private WebElement error;
    @FindBy(xpath = "//*[@id='reg_email']")
    private WebElement regEmailInput;

    @FindBy(id = "reg_password")
    private WebElement regPassowrdInput;

    @FindBy(name = "register")
    private WebElement registerButton;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement loginButton;

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage registerUserValidData(String email, String password) {
        logger.info("Registering user with valid data");
        registerUser(email, password);
        logger.info("Registering user with valid data done");
        return new LoggedUserPage(driver);
    }

    public MyAccountPage registerUserInvalidData(String email, String password) {
        logger.info("Registering user with invalid data");
        registerUser(email, password);
        logger.info("Registering user with invalid data done");
        return this;
    }

    private void registerUser(String email, String password) {
        regEmailInput.sendKeys(email);
        regPassowrdInput.sendKeys(password);
        registerButton.click();
    }

    public WebElement getError() {
        return error;
    }

    public LoggedUserPage logInValidData(String username, String password) {
        logger.info("Login user with valid data");
        logIn(username, password);
        logger.info("Login user with valid data done");
        return new LoggedUserPage(driver);
    }

    public MyAccountPage logInInvalidData(String username, String password) {
        logger.info("Login user with invalid data");
        logIn(username, password);
        logger.info("Login user with invalid data done");
        return this;
    }

    private void logIn(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
