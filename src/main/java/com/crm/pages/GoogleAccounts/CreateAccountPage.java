package com.crm.pages.GoogleAccounts;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.crm.utils.BasePage;

import static com.codeborne.selenide.Selenide.*;

public class CreateAccountPage extends BasePage {

//    Locators
    protected final SelenideElement addButton = $("button:has(svg.lucide-circle-plus-icon)");
    protected final SelenideElement accountName = $x("//textarea[@placeholder='Accounts Names List']");
    protected final SelenideElement accountLogin = $x("//input[@placeholder='Username' and @data-modal-field-id='create_username']");
    protected final SelenideElement accountPassword = $x("//input[@placeholder='Password' and @data-modal-field-id='create_password']");
    protected final SelenideElement emailLogin = $x("//input[@placeholder='Email Login' and @data-modal-field-id='create_email_login']");
    protected final SelenideElement emailPassword = $x("//input[@placeholder='Email Password' and @data-modal-field-id='create_email_password']");
    protected final SelenideElement accountId = $x ("//input[@placeholder='Account ID' and @data-modal-field-id='create_account_id']");
    protected final SelenideElement farmerComments = $x("//input[@placeholder='Farmer Comments' and @data-modal-field-id='create_farmer_comments']");
    protected final SelenideElement selectStatus = $x("//select[@name='status' and @data-modal-field-id='create_status']");
    protected final SelenideElement createButton = $x("//button[@id='create-google-accounts-button']");


    // Methods
    public void clickAddAccountButton(){
        smartClick(addButton);
        addButton.shouldBe(Condition.visible);
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
        logger.info("Account Password filled.");
    }

    public void fillEmailLogin (String eLogin){
        smartFill(emailLogin, eLogin);
        emailLogin.shouldHave(Condition.value(eLogin));
        logger.info("Email Login filled with: {}", eLogin);
    }

    public void fillEmailPassword(String ePassword){
        smartFill(emailPassword, ePassword);
        emailPassword.shouldHave(Condition.value(ePassword));
        logger.info("Email Password filled.");
    }

    public void fillAccountId(String accId){
        smartFill(accountId, accId);
        accountId.shouldHave(Condition.value(accId));
        logger.info("Account ID filled with: {}", accId);
    }

    public void fillFarmerComments(String comments){
        smartFill(farmerComments, comments);
        farmerComments.shouldHave(Condition.value(comments));
        logger.info("Farmer Comments filled.");
    }

    public void selectStatus(String status) {
        selectStatus.selectOptionByValue(status);
        selectStatus.shouldHave(Condition.value(status));
        logger.info("Status selected: {}", status);
    }

    public void clickCreateButton(){
        smartClick(createButton);
        createButton.shouldBe(Condition.visible);
        logger.info("Create button clicked.");
    }

}
