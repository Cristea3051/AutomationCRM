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
