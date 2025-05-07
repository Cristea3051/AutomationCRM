package com.crm.utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {
    private static final Logger logger = LogManager.getLogger(BasePage.class);
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
//        Configuration.headless = false;
        open("http://crm-dash/login");
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
        logger.info("Driver initialized and configured for test");
    }

    public void login() {
        String username = credentials.getProperty("global.admin.username");
        String password = credentials.getProperty("global.admin.password");

        logInfo("Attempting to log in with username: " + username);
        $("#login-username").setValue(username);
        $("#login-password").setValue(password);
        $("button.btn-alt-primary").click();

        logInfo("Login submitted");
    }

    public void logInfo(String message) {
        logger.info(message);
    }
}
