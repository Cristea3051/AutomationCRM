package com.crm.GoogleAccounts.CreateAccount;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CreateAccountPage {



//    Locators
    protected final SelenideElement addButton = $("button:has(svg.lucide-circle-plus-icon)");
    protected final SelenideElement accountName = $x("//textarea[@placeholder='Accounts Names List']");
    protected final SelenideElement createButton = $x("//button[@id='create-google-accounts-button']");

//    Methods
    public void clickAddButton() {
        addButton
                .shouldBe(visible)
                .click();

    }

    public void fillAccountName(String name) {
        accountName
                .shouldBe(visible)
                .setValue(name);
    }

    public void clickCreateButton() {
        createButton
                .scrollTo()
                .shouldBe(visible)
                .click();
    }

}
