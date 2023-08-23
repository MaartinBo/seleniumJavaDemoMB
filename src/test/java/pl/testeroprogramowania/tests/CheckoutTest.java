package pl.testeroprogramowania.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.testeroprogramowania.models.Customer;
import pl.testeroprogramowania.pages.HomePage;
import pl.testeroprogramowania.pages.OrderDetailsPage;
import pl.testeroprogramowania.utils.ExcelReader;
import pl.testeroprogramowania.utils.SeleniumHelper;

import java.io.IOException;

public class CheckoutTest extends BaseTest {

//    @Test
//    public void checkoutJavaProductTest() throws IOException {
//        ExtentTest test = extentReports.createTest("Checkout Java Product Test  ");
//        Customer customer = new Customer();
//
//        OrderDetailsPage orderDetailsPage = new HomePage(driver)
//                .openShopPage()
//                .openProduct("Java Selenium WebDriver")
//                .addProductToCart()
//                .viewCart()
//                .openAddressDetails()
//                .fillAddressDetails(customer, "some comments")
//                .clickOrderButtonWithoutEx();
//
//        test.log(Status.PASS, "Order product click done", SeleniumHelper.getScreenshot(driver));
//
//        Assert.assertEquals(orderDetailsPage.getOrderNotice().getText(), "Thank you. Your order has been received.");
//        Assert.assertEquals(orderDetailsPage.getProductName().getText(), "Java Selenium WebDriver × 1");
//        test.log(Status.PASS, "Order product done", SeleniumHelper.getScreenshot(driver));
//    }

    @Test(dataProvider = "data")
    public void checkoutProductTest(String Product, Float ExpectedPrice) throws IOException {
        ExtentTest test = extentReports.createTest("Checkout test " +  Product);
        Customer customer = new Customer();

        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .validateProductActualPrice(Product, ExpectedPrice)
                .openProduct(Product)
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .fillAddressDetails(customer, Product)
                .clickOrderButtonWithoutEx();

        test.log(Status.PASS, "Order product click done", SeleniumHelper.getScreenshot(driver));

        Assert.assertEquals(orderDetailsPage.getOrderNotice().getText(), "Thank you. Your order has been received.");
        Assert.assertTrue(orderDetailsPage.getProductName().getText().contains(Product));
        test.log(Status.PASS, "Order product done", SeleniumHelper.getScreenshot(driver));
    }

    @DataProvider
    public Object[][] data() throws IOException {
        return ExcelReader.readExcel("testProductsData.xls");
    }
}
