package com.crm.FacebookAccounts;

import com.crm.pages.FacebookAccounts.CreateAccountPage;
import com.crm.utils.BasePage;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.*;
public class CreateAccountTest extends BasePage {
    private final CreateAccountPage createAccount = new CreateAccountPage();

    @Test
    public void createAccount() {
        login("global.admin.username", "global.admin.password");
        open("http://192.168.0.126/facebook-accounts");
        createAccount.clickAddAccountButton();
        createAccount.fillAccountName("ONP_GG788_ PRT_G225200");
        createAccount.fillAccountLogin("TestLogin");
        createAccount.fillAccountPassword("PasswordTest");
        createAccount.fillEmailLogin("TestEmailLogin12344");
        createAccount.fillEmailPassword("Password1234");
        createAccount.fillAccountId("1334433");
        createAccount.fillIdVerificationDate(LocalDate.parse("2025-05-19"));
        createAccount.fillFarmerComments("comment1/comment2/comment3");
        createAccount.fillBHDate(LocalDate.parse("2025-05-19"));
        createAccount.selectStatus("Delivery");
        createAccount.fillBackupCode("225200");
        createAccount.fillMbDeliveryDate(LocalDate.parse("2025-05-19"));
        createAccount.fillTwoFa("we34asd34dfd45f4432");
        createAccount.fillSyncFromDate(LocalDate.parse("2025-05-23"));
        createAccount.selectCreditCardsOption(2);
        createAccount.fillBatchAndSource("Super");
        createAccount.fillFirstLastName("FirstLastNameAuto");
        createAccount.fillAccountRDP("GFA");
        createAccount.selectAccountProxy(2);
        createAccount.fillGEO("TEST");
        createAccount.fillLicense("TestLicense");
        createAccount.fillMbComments("MBcomment1/MBcomment2/MBcomment3");
        createAccount.selectAccountDomain(2);
        createAccount.selectMB("Dorin M");

//        createAccount.clickCreateButton();
        logger.info("CreateAccountTest executed");
    }
}