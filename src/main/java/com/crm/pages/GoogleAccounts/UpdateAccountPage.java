package com.crm.pages.GoogleAccounts;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UpdateAccountPage {
    protected final SelenideElement searchBar = $x("//*[@id='search']");
    protected final SelenideElement accountCheckbox = $x("//div[@id='google-accounts-table-app']//input[@type='checkbox']");
    protected final SelenideElement editAccountButton = $("button:has(svg.lucide-square-pen-icon)");
//    Form Locators
    protected final SelenideElement accountName = $x("//input[@placeholder='Accounts Name']");
    protected final SelenideElement accountLogin = $x("//input[@data-modal-field-id='edit_username']");
    protected final SelenideElement accountPassword = $x("//input[@data-modal-field-id='edit_password' and @ placeholder='Password']");
    protected final SelenideElement emailLogin = $x("//input[@data-modal-field-id='edit_email_login']");
    protected final SelenideElement emailPassword = $x("//input[@data-modal-field-id='edit_email_password']");
    protected final SelenideElement accountId = $x ("//input[@placeholder='Account ID' and @data-modal-field-id='edit_account_id']");
    protected final SelenideElement farmerComments = $x("//input[@data-modal-field-id='edit_farmer_comments']");
    protected final SelenideElement selectStatus = $x("//select[@data-modal-field-id='edit_status']");
    protected final SelenideElement selectIdVerificationDate = $x("//input[@data-modal-field-id='edit_id_verification']");
    protected final SelenideElement selectMbDeliveryDate = $x("//input[@data-modal-field-id='edit_mb_delivery_date']");
    protected final SelenideElement selectBHDate = $x("//input[@data-modal-field-id='edit_bh_date']");
    protected final SelenideElement selectSyncFromDate = $x("//input[@data-modal-field-id='edit_sync_from_date']");
    protected final SelenideElement selectBatch = $x ("//input[@data-modal-field-id='create_batch_id']");
    protected final SelenideElement selectAccountSource = $x ("//input[@data-modal-field-id='edit_source_id']");
    protected final SelenideElement twoFa = $x("//input[@data-modal-field-id='create_2fa']");
    protected final SelenideElement backupCode = $x("//input[@data-modal-field-id='edit_backup_code']");
    protected final SelenideElement selectCreditCards= $x("//select[@data-modal-field-id='edit_credit_cards']");
    protected final SelenideElement firstLastName = $x("//input[@data-modal-field-id='edit_first_last_name']");
    protected final SelenideElement accountRDP = $x("//input[@data-modal-field-id='edit_rdp_id']");
    protected final SelenideElement selectAccountProxy = $x("//select[@data-modal-field-id='edit_proxies']");
    protected final SelenideElement geo = $x("//input[@data-modal-field-id='edit_geo']");
    protected final SelenideElement license = $x("//input[@data-modal-field-id='create_license']");
    protected final SelenideElement mbComments = $x("//input[@data-modal-field-id='edit_mb_comments']");
    protected final SelenideElement createButton = $x("//button[@id='edit-google-accounts-button']");
    protected final SelenideElement selectAccountDomain = $x("//select[@data-modal-field-id='edit_domains']");
    protected final SelenideElement selectMediaBuyer = $x("//input[@data-modal-field-id='edit_account_owner']");

}
