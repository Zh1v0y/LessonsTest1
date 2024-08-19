package lesson7.mts.tests;

import lesson7.mts.pages.MtsHomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MtsTest {

    private static WebDriver driver;
    private static MtsHomePage mtsHomePage;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        mtsHomePage = new MtsHomePage(driver);
        mtsHomePage.acceptCookiesIfPresent();
    }

    @Test
    @Order(1)
    public void testOnlineReplenishmentHeader() {
        String expectedHeader = "Онлайн пополнение\nбез комиссии";
        String actualHeader = mtsHomePage.getOnlineReplenishmentHeaderText();
        String message = "Заголовок блока не совпадает с ожидаемым.";
        assertEquals(expectedHeader, actualHeader, message);
    }

    @Test
    @Order(2)
    public void testOnlineReplenishmentPaymentLogos() {
        String message = "Некоторые логотипы платёжных систем не отображаются.";
        assertTrue(mtsHomePage.arePaymentLogosDisplayedOnlineReplenishment(), message);
    }

    @Test
    @Order(4)
    public void testServiceLink() {
        String expectedLink = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        String linkHref = mtsHomePage.getServiceLinkHrefOnlineReplenishment();
        assertEquals(expectedLink, linkHref);

        mtsHomePage.clickServiceLinkOnlineReplenishment();
        String currentUrl = driver.getCurrentUrl();
        assertEquals(expectedLink, currentUrl);
    }

    @Test
    @Order(3)
    public void testOnlineRecharge() {
        // Заполнение полей
        mtsHomePage.enterPhoneNumberOnlineReplenishment("297777777");
        mtsHomePage.enterAmountOnlineReplenishment("10");
        // Нажать кнопку "Продолжить"
        mtsHomePage.clickContinueButtonOnlineReplenishment();
        // Проверяем, что появилось сообщение об ошибке
        String message = "Ошибка не отображается для неверного номера.";
        assertTrue(mtsHomePage.isErrorMessageDisplayed(), message);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

