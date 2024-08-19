package mts.singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverSingleton {

    private static WebDriverSingleton INSTANCE;
    private WebDriver driver;

    public WebDriverSingleton() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static WebDriverSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WebDriverSingleton();
        }
        return INSTANCE;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Сбрасываем ссылку на драйвер после закрытия
            INSTANCE = null; // Сбрасываем экземпляр Singleton, если нужно
        }
    }
}
