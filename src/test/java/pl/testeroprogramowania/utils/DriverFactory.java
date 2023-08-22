package pl.testeroprogramowania.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver getDriver(String browser) {
        if ((browser.equals("chrome"))) {
            return new ChromeDriver();
        } else if ((browser.equals("firefox"))) {
            return new FirefoxDriver();
        } else {
            System.out.println("We support only chrome and firefox");
            return null;
        }
    }
}
