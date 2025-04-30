package com.crm.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.*;

public class BasePage {

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";

        open("http://crm-dash/login");

        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
    }
}
