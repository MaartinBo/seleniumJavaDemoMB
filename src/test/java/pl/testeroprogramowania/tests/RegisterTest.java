package pl.testeroprogramowania.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.pages.HomePage;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUserTest() {
        WebElement entryTitle = new HomePage(driver).openMyAccountPage()
                .registerUser("test321@test.pl", "test@test123.pl").getEntryTitle();

        Assert.assertTrue(entryTitle.isDisplayed());
    }
}
