package com.crm.GoogleAccounts;

import com.crm.pages.GoogleAccounts.CreateAccountPage;
import com.crm.utils.BasePage;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class CreateAccountTest extends BasePage {
    private final CreateAccountPage createAccount = new CreateAccountPage();

    @Test

    public void createAccount() {

        createAccount.performLogin();
        open("http://crm-dash/google-accounts-v2");
        createAccount.clickAddAccountButton();
        createAccount.fillAccountName("ONP_GG788_PRT_G225200");
        createAccount.clickCreateButton();
        logger.info("CreateAccountTest executed");
    }
}