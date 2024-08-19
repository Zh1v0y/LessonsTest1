package mts.tests;

import mts.pages.MtsHomePage;
import mts.singleton.WebDriverSingleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected MtsHomePage mtsHomePage;

    @BeforeEach
    public void setUp() {
        WebDriver driver = WebDriverSingleton.getInstance().getDriver();
        mtsHomePage = new MtsHomePage(driver);
        mtsHomePage.acceptCookiesIfPresent();
    }

    @AfterEach
    public void tearDown() {
        WebDriverSingleton.getInstance().quitDriver();
    }
}

