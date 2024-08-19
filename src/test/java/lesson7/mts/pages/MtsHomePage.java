package lesson7.mts.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MtsHomePage {

    private WebDriver driver;

    public MtsHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class, 'cookie')]")
    private WebElement cookieBanner;

    @FindBy(xpath = "//*[contains(@id, 'cookie-agree')]")
    private WebElement acceptCookiesButton;

    // Локатор для названия блока "Онлайн пополнение без комиссии"
    @FindBy(xpath = "//div[contains(@class, 'pay__wrapper')]//h2")
    private WebElement onlineReplenishmentHeader;

    // Локатор для логотипов платёжных систем блока "Онлайн пополнение без комиссии"
    @FindBy(xpath = "//div[contains(@class, 'pay__partners')]//ul/li/img")
    private List<WebElement> paymentLogos;

    // Локатор для ссылки «Подробнее о сервисе» блока "Онлайн пополнение без комиссии"
    @FindBy(xpath = "//a[text()='Подробнее о сервисе']")
    private WebElement serviceLink;

    // Локатор для поля ввода телефона блока "Онлайн пополнение без комиссии"
    @FindBy(xpath = "//*[contains(@id, 'connection-phone')]")
    private WebElement phoneInput;

    // Локатор для поля ввода суммы блока "Онлайн пополнение без комиссии"
    @FindBy(xpath = "//*[contains(@id, 'connection-sum')]")
    private WebElement amountInput;

    // Локатор для кнопки "Продолжить" блока "Онлайн пополнение без комиссии"
    @FindBy(xpath = "//button[text()='Продолжить']")
    private WebElement continueButton;

    // Локатор для сообщения об ошибке "Неверно указан номер" блока "Онлайн пополнение без комиссии"
    @FindBy(xpath = "//p[text()='Неверно указан номер']")
    private WebElement errorMessage;

    public void acceptCookiesIfPresent() {
        if (cookieBanner.isDisplayed()) {
            acceptCookiesButton.click();
        }
    }

    public String getOnlineReplenishmentHeaderText() {
        return onlineReplenishmentHeader.getText();
    }

    public boolean arePaymentLogosDisplayedOnlineReplenishment() {
        return paymentLogos.stream().allMatch(WebElement::isDisplayed);
    }

    public void clickServiceLinkOnlineReplenishment() {
        serviceLink.click();
    }

    public String getServiceLinkHrefOnlineReplenishment() {
        return serviceLink.getAttribute("href");
    }

    public void enterPhoneNumberOnlineReplenishment(String phoneNumber) {
        phoneInput.clear();
        phoneInput.sendKeys(phoneNumber);
    }

    public void enterAmountOnlineReplenishment(String amount) {
        amountInput.clear();
        amountInput.sendKeys(amount);
    }

    public void clickContinueButtonOnlineReplenishment() {
        continueButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
}

