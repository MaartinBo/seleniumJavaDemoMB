package pl.testeroprogramowania.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.models.Customer;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.OrderDetailsPage;
import pl.testeroprogramowania.utils.SeleniumHelper;

import java.io.IOException;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutJavaProductTest() throws IOException {
        ExtentTest test = extentReports.createTest("Checkout Java Product Test  ");
        Customer customer = new Customer();

        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .fillAddressDetails(customer, "some comments")
                .clickOrderButtonWithoutEx();

        test.log(Status.PASS, "Order product click done", SeleniumHelper.getScreenshot(driver));

        Assert.assertEquals(orderDetailsPage.getOrderNotice().getText(), "Thank you. Your order has been received.");
        Assert.assertEquals(orderDetailsPage.getProductName().getText(), "Java Selenium WebDriver × 1");
        test.log(Status.PASS, "Order product done", SeleniumHelper.getScreenshot(driver));
    }
}
