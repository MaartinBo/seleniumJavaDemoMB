package pl.testeroprogramowania.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public static WebDriver getDriver() {
//         System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe"); // Replace with the actual path
        // Set the path to the ChromeDriver executable if not exists in system env var
//        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver();
    }
}
