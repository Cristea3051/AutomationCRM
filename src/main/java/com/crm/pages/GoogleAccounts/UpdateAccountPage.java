package com.crm.pages.GoogleAccounts;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.crm.utils.BasePage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class UpdateAccountPage extends BasePage {

//    locators
    protected final SelenideElement searchBar = $x("//*[@id='search']");
    protected final SelenideElement accountCheckbox = $x("(//div[contains(@class, 'rgRow')]//input[@type='checkbox'])[2]");
    protected final SelenideElement editAccountButton = $("button:has(svg.lucide-square-pen-icon)");
//    Form Locators
    protected final SelenideElement accountName = $x("//input[@placeholder='Account Name']");
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
    protected final SelenideElement license = $x("//input[@data-modal-field-id='edit_license']");
    protected final SelenideElement mbComments = $x("//input[@data-modal-field-id='edit_mb_comments']");
    protected final SelenideElement applyButton = $x("//button[@id='edit-google-accounts-button']");
    protected final SelenideElement selectAccountDomain = $x("//select[@data-modal-field-id='edit_domains']");
    protected final SelenideElement selectMediaBuyer = $x("//input[@data-modal-field-id='edit_account_owner']");


    // Methods
    public void searchAccount(String name) {
        smartFill(searchBar, name);
        searchBar.shouldHave(Condition.value(name));
        logger.info("Searched Account - {}", name);
    }

    public void clickSearchedAccount(){
        smartClick(accountCheckbox);
        accountCheckbox.shouldBe(Condition.visible);
        logger.info("Account is selected with checbox");
    }

    public void clickEditAccountButton(){
        smartClick(editAccountButton);
        editAccountButton.shouldBe(Condition.visible);
        logger.info("Add Account button clicked.");
    }

    public void fillAccountName(String name) {
        smartFill(accountName, name);
        accountName.shouldHave(Condition.value(name));
        logger.info("Account Name filled with: {}", name);
    }

    public void fillAccountLogin(String username){
        smartFill(accountLogin, username);
        accountLogin.shouldHave(Condition.value(username));
        logger.info("Account Login filled with: {}", username);
    }

    public void fillAccountPassword(String password){
        smartFill(accountPassword, password);
        accountPassword.shouldHave(Condition.value(password));
        logger.info("Account Password filled with: {}", password);
    }

    public void fillEmailLogin (String eLogin){
        smartFill(emailLogin, eLogin);
        emailLogin.shouldHave(Condition.value(eLogin));
        logger.info("Email Login filled with: {}", eLogin);
    }

    public void fillEmailPassword(String ePassword){
        smartFill(emailPassword, ePassword);
        emailPassword.shouldHave(Condition.value(ePassword));
        logger.info("Email Password filled: {}", ePassword);
    }

    public void fillAccountId(String accId){
        smartFill(accountId, accId);
        accountId.shouldHave(Condition.value(accId));
        logger.info("Account ID filled with: {}", accId);
    }

    public void fillFarmerComments(String comments){
        smartFill(farmerComments, comments);
        farmerComments.shouldHave(Condition.value(comments));
        logger.info("Farmer Comments filled {}", comments );
    }

    public void selectStatus(String status) {
        selectStatus.selectOptionByValue(status);
        selectStatus.shouldHave(Condition.value(status));
        logger.info("Status selected: {}", status);
    }

    public void fillTwoFa(String twoFaValue){
        smartFill(twoFa, twoFaValue);
        twoFa.shouldHave(Condition.value(twoFaValue));
        logger.info("2Fa value is  {}", twoFaValue);
    }

    public void fillBackupCode(String backupCodeValue){
        smartFill(backupCode, backupCodeValue);
        backupCode.shouldHave(Condition.value(backupCodeValue));
        logger.info("Backup Code value is  {}", backupCodeValue);
    }

    public void fillBHDate(LocalDate date){
        smartSelectSpecificDay(selectBHDate, date);
        String expectedValue = date.format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));
        selectIdVerificationDate.shouldHave(Condition.value(expectedValue));
        logger.info("BH Date date is {}", expectedValue);
    }

    public void fillIdVerificationDate(LocalDate date) {
        smartSelectSpecificDay(selectIdVerificationDate, date);
        String expectedValue = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        selectIdVerificationDate.shouldHave(Condition.value(expectedValue));
        logger.info("Id verification date is {}", expectedValue);
    }

    public void fillMbDeliveryDate(LocalDate date) {
        smartSelectSpecificDay(selectMbDeliveryDate, date);
        String expectedValue = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        selectMbDeliveryDate.shouldHave(Condition.value(expectedValue));
        logger.info("MB Delivery date is {}", expectedValue);
    }

    public void fillSyncFromDate(LocalDate date){
        smartSelectSpecificDay(selectSyncFromDate, date);
        String expectedValue = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        selectSyncFromDate.shouldHave(Condition.value(expectedValue));
        logger.info("Sync From date is {}", expectedValue);
    }

    public void selectCreditCardsOption(int index) {
        selectCreditCards.selectOption(index);
        String selectedText = selectCreditCards.getSelectedOption().getText();
        logger.info("Credit Card option selected at index {}: {}", index, selectedText);
    }

    public void fillBatchAndSource(String keyword) {
        smartAutocompleteSelect(selectBatch, keyword);
        smartAutocompleteSelect(selectAccountSource, keyword);
        selectBatch.shouldHave(Condition.value(keyword));
        logger.info("Batch and Source filled with value: {}", keyword);
    }

    public void fillFirstLastName(String firstLastnameValue){
        smartFill(firstLastName, firstLastnameValue);
        firstLastName.shouldHave(Condition.value(firstLastnameValue));
        logger.info("First/Last Name value is  {}", firstLastnameValue);
    }
    public void fillAccountRDP(String accountRDPValue){
        smartAutocompleteSelect(accountRDP, accountRDPValue);
        accountRDP.shouldHave(Condition.value(accountRDPValue));
        logger.info("Account RDP value is  {}", accountRDPValue);

    }

    public void selectAccountProxy(int index){
        selectAccountProxy.selectOption(index);
        String selectedText = selectAccountProxy.getSelectedOption().getText();
        logger.info("Proxy selected at index {}: {}", index, selectedText);
    }

    public void fillGEO(String geoValue){
        smartFill(geo, geoValue);
        geo.shouldHave(Condition.value(geoValue));
        logger.info("GEO value is  {}", geoValue);
    }

    public void fillLicense(String licenseValue) {
        smartFill(license, licenseValue);
        license.shouldHave(Condition.value(licenseValue));
        logger.info("license value is  {}", licenseValue);
    }

    public void fillMbComments(String commentsValue) {
        smartFill(mbComments, commentsValue);
        mbComments.shouldHave(Condition.value(commentsValue));
        logger.info("MB Comment value is  {}", commentsValue);
    }

    public void selectAccountDomain (int index){
        selectAccountDomain.selectOption(index);
        String selectedText = selectAccountDomain.getSelectedOption().getText();
        logger.info("Domain selected at index {}: {}", index, selectedText);
    }

    public void selectMB(String mediaBuyerValue){
        smartAutocompleteSelect(selectMediaBuyer, mediaBuyerValue);
        selectMediaBuyer.shouldHave(Condition.value(mediaBuyerValue));
        logger.info("Media Buyer filled with value: {}", mediaBuyerValue);
    }


    public void applyButton(){
        smartClick(applyButton);
        applyButton.shouldBe(Condition.visible);
        logger.info("Create button clicked.");
    }
}
