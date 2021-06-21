package com.andrewfoote.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * AccountSettingsPage represents the account page shown in Hudl when navigating from the nav bar
 */
public class AccountSettingsPage extends HudlHome {

    public AccountSettingsPage() {
        this.getDriver();
    }

    //LOCATORS
    @FindBy(id = "email")
    private WebElementFacade emailAddress;

    //ACTIONS
    /**
     * This gets the email address text from the AccountSettings page
     * @return email address as text
     */
    public String getEmailAddress() {
        return emailAddress.getAttribute("value");
    }
}
