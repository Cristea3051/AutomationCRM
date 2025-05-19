package com.crm.GoogleAccounts;

import com.crm.pages.GoogleAccounts.CreateAccountPage;
import com.crm.utils.BasePage;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.*;

public class CreateAccountTest extends BasePage {
    private final CreateAccountPage createAccount = new CreateAccountPage();

    @Test

    public void createAccount() {
        login("global.admin.username", "global.admin.password");
        open("http://192.168.0.57/google-accounts-v2");
        createAccount.clickAddAccountButton();
        createAccount.fillAccountName("ONP_GG788_PRT_G225200");
        createAccount.fillAccountLogin("TestLogin");
        createAccount.fillAccountPassword("PasswordTest");
        createAccount.fillEmailLogin("TestEmailLogin12344");
        createAccount.fillEmailPassword("Password1234");
        createAccount.fillAccountId("1334433");
        createAccount.fillFarmerComments("comment1/comment2/comment3");
        createAccount.selectStatus("Delivery");
        createAccount.fillIdVerificationDate(LocalDate.parse("2025-05-19"));
        createAccount.fillBackupCode("225200");
        createAccount.fillMbDeliveryDate(LocalDate.parse("2025-05-19"));
        createAccount.fillTwoFa("we34asd34dfd45f4432");
        createAccount.fillSyncFromDate(LocalDate.parse("2025-05-23"));
        createAccount.selectCreditCardsOption(2);

//        createAccount.clickCreateButton();
        logger.info("CreateAccountTest executed");
    }
}