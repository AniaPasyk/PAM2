package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    private static final Duration implicitTimeout = Duration.ofSeconds(10);

    public static WebDriver getDriver() {

        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.http.factory", "jdk-http-client");

       ChromeOptions chromeOptions = new ChromeOptions();
       chromeOptions.addArguments(
               "--window-size=2048,1536",
                "--no-default-browser-check",
               "--ignore-certificate-errors",
                "--disable-popup-blocking",
                "--disable-dev-shm-usage",
                "--no-sandbox");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().timeouts().implicitlyWait(implicitTimeout);

       return driver;
    }
}

