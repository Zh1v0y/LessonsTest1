package mts.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class MtsTest extends BaseTest {

    private static final String PLACEHOLDERS_MESSAGE = "Заполнитель не соответствует ожидаемому.";
    private static final String CURRENT_SERVICE_MESSAGE = "Текущий сервис не соответствует ожидаемому.";

    @Test
    @Description("Проверить надписи в незаполненных полях сервиса 'Услуги связи'")
    @DisplayName("Тест надписей для услуг связи")
    public void testPlaceholdersForConnection() {
        String service = "Услуги связи";
        mtsHomePage.selectService(service);

        assertAll("Проверки заполнителей для услуг связи.",
                () -> assertEquals(service, mtsHomePage.getCurrentService(), CURRENT_SERVICE_MESSAGE),
                () -> assertEquals("Номер телефона", mtsHomePage.getConnectionPhonePlaceholder(), PLACEHOLDERS_MESSAGE),
                () -> assertEquals("Сумма", mtsHomePage.getConnectionSumPlaceholder(), PLACEHOLDERS_MESSAGE),
                () -> assertEquals("E-mail для отправки чека", mtsHomePage.getConnectionEmailPlaceholder(), PLACEHOLDERS_MESSAGE)
        );
    }

    @Test
    @Description("Проверить надписи в незаполненных полях сервиса 'Домашний интернет'")
    @DisplayName("Тест надписей для домашнего интернета")
    public void testPlaceholdersForInternet() {
        String service = "Домашний интернет";
        mtsHomePage.selectService(service);

        assertAll("Проверки заполнителей для домашнего интернета.",
                () -> assertEquals(service, mtsHomePage.getCurrentService(), CURRENT_SERVICE_MESSAGE),
                () -> assertEquals("Номер абонента", mtsHomePage.getInternetPhonePlaceholder(), PLACEHOLDERS_MESSAGE),
                () -> assertEquals("Сумма", mtsHomePage.getInternetSumPlaceholder(), PLACEHOLDERS_MESSAGE),
                () -> assertEquals("E-mail для отправки чека", mtsHomePage.getInternetEmailPlaceholder(), PLACEHOLDERS_MESSAGE)
        );
    }

    @Test
    @Description("Проверить надписи в незаполненных полях сервиса 'Рассрочка'")
    @DisplayName("Тест надписей для рассрочки")
    public void testPlaceholdersForInstalment() {
        String service = "Рассрочка";
        mtsHomePage.selectService(service);

        assertAll("Проверки заполнителей для рассрочки.",
                () -> assertEquals(service, mtsHomePage.getCurrentService(), CURRENT_SERVICE_MESSAGE),
                () -> assertEquals("Номер счета на 44", mtsHomePage.getScoreInstalmentPlaceholder(), PLACEHOLDERS_MESSAGE),
                () -> assertEquals("Сумма", mtsHomePage.getInstalmentSumPlaceholder(), PLACEHOLDERS_MESSAGE),
                () -> assertEquals("E-mail для отправки чека", mtsHomePage.getInstalmentEmailPlaceholder(), PLACEHOLDERS_MESSAGE)
        );
    }

    @Test
    @Description("Проверить надписи в незаполненных полях сервиса 'Задолженность'")
    @DisplayName("Тест надписей для задолженности")
    public void testPlaceholdersForArrears() {
        String service = "Задолженность";
        mtsHomePage.selectService(service);

        assertAll("Проверки заполнителей для задолженности.",
                () -> assertEquals(service, mtsHomePage.getCurrentService(), CURRENT_SERVICE_MESSAGE),
                () -> assertEquals("Номер счета на 2073", mtsHomePage.getScoreArrearsPlaceholder(), PLACEHOLDERS_MESSAGE),
                () -> assertEquals("Сумма", mtsHomePage.getArrearsSumPlaceholder(), PLACEHOLDERS_MESSAGE),
                () -> assertEquals("E-mail для отправки чека", mtsHomePage.getArrearsEmailPlaceholder(), PLACEHOLDERS_MESSAGE)
        );
    }

    @Test
    @Description("В окне оплаты проверить корректность отображения суммы (в том числе на кнопке), номера телефона, " +
            "а также надписей в незаполненных полях для ввода реквизитов карты, наличие иконок платёжных систем")
    @DisplayName("Тест окна оплаты")
    public void testBePaidApp() {
        String phoneNumber = "297777777";
        String amount = "15.50";
        mtsHomePage.enterDataForConnection(phoneNumber, amount);

        assertAll("Проверки для окна оплаты.",
                () -> assertTrue(mtsHomePage.isBePaidIframeDisplayed(), "Окно для оплаты не отображается."),
                () -> assertTrue(mtsHomePage.getBePaidAmount().contains(amount), "Сумма не соответствует ожидаемой."),
                () -> assertTrue(mtsHomePage.getBePaidDescription().contains(phoneNumber), "Телефон не соответствует ожидаемому."),
                () -> assertTrue(mtsHomePage.getBePaidButtonText().contains(amount), "Сумма на кнопке не соответствует ожидаемой."),
                () -> assertEquals("Номер карты", mtsHomePage.getBePaidCardInputText(), PLACEHOLDERS_MESSAGE),
                () -> assertEquals("Срок действия", mtsHomePage.getBePaidValidityCardText(), PLACEHOLDERS_MESSAGE),
                () -> assertEquals("CVC", mtsHomePage.getBePaidCvcCardText(), PLACEHOLDERS_MESSAGE),
                () -> assertEquals("Имя держателя (как на карте)", mtsHomePage.getBePaidCardholderNameText(), PLACEHOLDERS_MESSAGE),
                () -> assertTrue(mtsHomePage.isBePaidVisaIconDisplayed(), "Иконка Visa не отображается."),
                () -> assertTrue(mtsHomePage.isBePaidMastercardIconDisplayed(), "Иконка Mastercard не отображается."),
                () -> assertTrue(mtsHomePage.isBePaidBelkartIconDisplayed(), "Иконка Belkart не отображается."),
                () -> assertTrue(mtsHomePage.isBePaidMaestroIconDisplayed(), "Иконка Maestro не отображается."),
                () -> assertTrue(mtsHomePage.isBePaidMirIconDisplayed(), "Иконка Mir не отображается.")
        );
    }
}

