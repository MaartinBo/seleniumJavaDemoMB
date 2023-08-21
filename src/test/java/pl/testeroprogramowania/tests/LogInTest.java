package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class LogInTest extends BaseTest {

    @Test
    public void logInTest() {
        int random = (int) (Math.random() * 10000);

        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .logInValidData("test22@test.pl", "test22@test.pl")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void logInWithInvalidData() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .logInInvalidData("testlorem@test.pl", "test1@te")
                .getError();

        Assert.assertTrue(error.getText().contains("Incorrect username or password."), "Expected error test doesn't match");
    }
}
