package pl.testeroprogramowania.utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SeleniumHelper {

    public static void waitForClickable(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(10)));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForClickable(By locator, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(10)));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static Media getScreenshot(WebDriver driver) throws IOException {
        String path = takeScreenshot(driver);
        return MediaEntityBuilder.createScreenCaptureFromPath(path).build();
    }

    private static String takeScreenshot(WebDriver driver) throws IOException {
        String dateTimeString = getCurrentFormattedDateTime();
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        String path = "src/test/resources/screenshots/screenshot" + dateTimeString + ".png";
        FileUtils.copyFile(file, new File(path));
        return path;
    }

    public static String getCurrentFormattedDateTime() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define a custom date and time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        // Format the current date and time as a string

        // Return the formatted date and time
        return currentDateTime.format(formatter);
    }
}
