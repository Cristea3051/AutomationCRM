package com.crm.utils;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.*;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {
    public static final Logger logger = LogManager.getLogger(BasePage.class);
    private final Properties credentials = loadCredentials();

    private Properties loadCredentials() {
        Properties props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("credentials.properties")) {
            if (input == null) {
                throw new IOException("credentials.properties not found");
            }
            props.load(input);
        } catch (IOException e) {
            logger.error("Failed to load credentials: {}", e.getMessage());
            throw new RuntimeException(e);
        }
        return props;
    }

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        // Configuration.headless = false;
        open("http://192.168.0.57/login");
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
        logger.info("Driver initialized and configured for test");
    }

    public void login(String usernameKey, String passwordKey) {
        Properties credentials = loadCredentials();

        String username = credentials.getProperty(usernameKey);
        String password = credentials.getProperty(passwordKey);

        if (username == null || password == null) {
            throw new IllegalStateException("Username or password not found in credentials.properties");
        }

        logger.info("Attempting to log in with username: {}", username);
        $("#login-username").setValue(username);
        $("#login-password").setValue(password);
        $("button.btn-alt-primary").click();
        logger.info("Login submitted");
    }

    public static void waitSleep(int timeoutInSeconds) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        CompletableFuture<Void> future = new CompletableFuture<>();
        executor.schedule(() -> future.complete(null), timeoutInSeconds, TimeUnit.SECONDS);
        try {
            future.get();
        } catch (InterruptedException | ExecutionException ignored) {
        } finally {
            executor.shutdown();
        }
    }

    public static void clickWithJS(SelenideElement element) {
        executeJavaScript("arguments[0].click();", element);
    }

    public static void fillInputWithJS(SelenideElement inputField, String value) {
        executeJavaScript("arguments[0].value = arguments[1];", inputField, value);
        executeJavaScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", inputField);
    }

    public static void smartClick(SelenideElement target) {
        try {
            target.shouldBe(Condition.exist)
                    .shouldBe(Condition.enabled)
                    .shouldBe(Condition.visible)
                    .hover();
            target.click();
        } catch (Exception | Error e) {
            System.out.println(e.getMessage());
            logger.warn("Click on {} with JS executor", target);
            clickWithJS(target);
        }
    }

    public static void smartFill(SelenideElement inputField, String value) {
        try {
            inputField.shouldBe(Condition.exist)
                    .shouldBe(Condition.enabled)
                    .shouldBe(Condition.visible);
//                    .hover()
//                    .click();
            inputField.setValue(value);
        } catch (Exception | Error e) {
            System.out.println(e.getMessage());
            logger.warn("Filling input {} with value '{}' using JS executor fallback", inputField, value);
            fillInputWithJS(inputField, value);
        }
    }

//    Smart select date
public static void smartSelectSpecificDay(SelenideElement dateInput, LocalDate date) {
    try {
        dateInput.shouldBe(Condition.exist)
                .shouldBe(Condition.visible)
                .shouldBe(Condition.enabled);
        executeJavaScript("arguments[0].click();", dateInput);

        SelenideElement calendar = $(".flatpickr-calendar.open")
                .shouldBe(Condition.visible)
                .shouldBe(Condition.exist);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.ENGLISH);
        String formattedDate = date.format(formatter);

        SelenideElement targetDay = calendar.$("span.flatpickr-day[aria-label='" + formattedDate + "']")
                .shouldBe(Condition.visible)
                .shouldBe(Condition.enabled);

        targetDay.click();

        logger.info("Selected date is '{}' for input field {}", formattedDate, dateInput);

    } catch (Exception | AssertionError e) {
        logger.warn("Error while selecting date '{}' for input field {}: {}", date, dateInput, e.getMessage());
        throw e;
    }
}

// Smart select with autocomplete
public static void smartAutocompleteSelect(SelenideElement input, String textToType) {
    try {
        input.shouldBe(Condition.visible)
                .shouldBe(Condition.enabled);

        input.click();
        input.setValue(textToType);

        SelenideElement autocompleteList = $("#autocomplete-list.autocomplete-items")
                .shouldBe(Condition.visible);


        SelenideElement matchingOption = autocompleteList.$("div")
                .shouldBe(Condition.enabled)
                .shouldBe(Condition.enabled);

        matchingOption.click();

        logger.info("Selected autocomplete option: {}", input);
    } catch (Exception | AssertionError e) {
        logger.warn("Failed to select autocomplete option for '{}'. Error: {}", input, e.getMessage());
        throw e;
    }
}

}