import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Browser {
    private static WebDriver browser;
    private static WebDriverWait wait;

    public static void setup() {
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        wait = new WebDriverWait(browser, Duration.ofSeconds(3));

    }

    public static void exitBrowser() {
        browser.quit();
    }

    public static WebDriver getDriver() {
        return browser;
    }

    public static WebDriverWait getWait() {
        return wait;
    }
}
