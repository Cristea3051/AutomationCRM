package com.crm.GoogleAccounts.CreateAccount;

import com.crm.utils.BasePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class CreateAccountTest extends BasePage {
    private final CreateAccountPage createAccount = new CreateAccountPage();
    @BeforeMethod
    public void login() {
        super.login();
    }

    @Test
    public void createAccount() {
        open("http://crm-dash/google-accounts-v2");
        createAccount.clickAddButton();
        createAccount.fillAccountName("Automated_Google_Account");
        createAccount.clickCreateButton();
        sleep(6000);
        logInfo("CreateAccountTest executed");
    }
}