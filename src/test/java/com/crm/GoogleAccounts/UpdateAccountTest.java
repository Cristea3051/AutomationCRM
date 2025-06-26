package com.crm.GoogleAccounts;

import com.crm.pages.GoogleAccounts.UpdateAccountPage;
import com.crm.utils.BasePage;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.*;
public class UpdateAccountTest extends BasePage {
    private final UpdateAccountPage updateAccount = new UpdateAccountPage();

    @Test
    public void updatedAccount() {
        login("global.admin.username", "global.admin.password");
        open("http://192.168.0.126/google-accounts-v2");
        updateAccount.searchAccount("ONP-FR181");
        updateAccount.clickSearchedAccount();
        updateAccount.clickEditAccountButton();
        updateAccount.fillAccountName("PRT_G225200");
        updateAccount.fillAccountLogin("TestLogin");
        updateAccount.fillAccountPassword("PasswordTest");
        updateAccount.fillEmailLogin("TestEmailLogin12344");
        updateAccount.fillSyncFromDate(LocalDate.parse("2025-05-23"));
        updateAccount.fillEmailPassword("Password1234");
        updateAccount.fillAccountId("1334433");
        updateAccount.fillIdVerificationDate(LocalDate.parse("2025-05-25"));
        updateAccount.fillFarmerComments("comment1/comment2/comment3");
        updateAccount.fillBHDate(LocalDate.parse("2025-05-25"));
        updateAccount.selectStatus("Delivery");
        updateAccount.fillBackupCode("225200");
        updateAccount.fillMbDeliveryDate(LocalDate.parse("2025-05-25"));
        updateAccount.fillTwoFa("we34asd34dfd45f4432");
        updateAccount.selectCreditCardsOption(2);
        updateAccount.fillBatchAndSource("Super");
        updateAccount.fillFirstLastName("FirstLastNameAuto");
        updateAccount.fillAccountRDP("GFA");
        updateAccount.selectAccountProxy(2);
        updateAccount.fillGEO("TEST");
        updateAccount.fillLicense("TestLicense");
        updateAccount.fillMbComments("MBcomment1/MBcomment2/MBcomment3");
        updateAccount.selectAccountDomain(2);
        updateAccount.selectMB("Dorin M");

//        createAccount.clickCreateButton();
        logger.info("CreateAccountTest executed");
    }
}