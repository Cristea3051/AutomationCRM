package com.crm.pages.GoogleAccounts;

import com.codeborne.selenide.SelenideElement;
import com.crm.utils.BasePage;

import static com.codeborne.selenide.Selenide.*;

public class CreateAccountPage extends BasePage {

//    Locators
    protected final SelenideElement addButton = $("button:has(svg.lucide-circle-plus-icon)");
    protected final SelenideElement accountName = $x("//textarea[@placeholder='Accounts Names List']");
    protected final SelenideElement createButton = $x("//button[@id='create-google-accounts-button']");
    //    Methods
    public void performLogin() {
        String username = getCredentials().getProperty("global.admin.username");
        String password = getCredentials().getProperty("global.admin.password");

        if (username == null || password == null) {
            throw new IllegalStateException("Username or password not found in credentials.properties");
        }

        login(username, password);
        logger.info("Login performed from CreateAccountPage");
    }

    public void clickAddAccountButton(){
        smartClick(addButton);
        waitSleep(2);
    }

    public void fillAccountName(String value) {
        smartFill(accountName, value);
        waitSleep(2);
    }

    public void clickCreateButton(){
        smartClick(createButton);
        waitSleep(2);
    }

}
