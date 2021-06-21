package com.andrewfoote.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

/**
 * HudlWebsiteHome represents the main website entry point at Hudl.com
 */
public class HudlWebsiteHome extends PageObject {

    public HudlWebsiteHome() { this.getDriver(); }

    // Page text element that can be used for assertions and protected items used in sub-classes
    protected static final String VALUE_ATTRIBUTE_TEXT = "value";
    private static final String WEBSITE_TITLE = "Performance analysis tools for sports teams and athletes at every level.";

    //Locators
    @FindBy(css = ".login")
    private WebElementFacade loginButton;

    //Actions
    /**
     * This navigates to the Hudl log in page
     */
    protected void goToLoginPage() {
        openAt(System.getProperty("test.url"));
        loginButton.click();
    }

    /**
     * This checks whether the Hudl website front page is displayed
     * @return true/false whether the front page is displayed
     */
    public boolean isDisplayed() {
        if(this.getTitle().equals(WEBSITE_TITLE) &&
                loginButton.isVisible()) {
            return true;
        } else {
            return false;
        }
    }
}
