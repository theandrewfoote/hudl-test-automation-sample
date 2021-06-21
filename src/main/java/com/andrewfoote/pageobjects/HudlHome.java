package com.andrewfoote.pageobjects;

import com.andrewfoote.pageobjects.navigationbar.NavigationBar;
import org.openqa.selenium.support.FindBy;

/**
 * HudlHome represents the page shown after logging in to Hudl.com
 */
public class HudlHome extends HudlWebsiteHome {

    public HudlHome() { this.getDriver(); }

    //LOCATORS
    @FindBy(css = "nav.hui-webnav__grid-col--onewhole.hui-globalnav.uni-env--dark.uni-environment--dark")
    private NavigationBar navigationBar;

    //ACTIONS
    /**
     * This gets the email address visible in the Hudl navigation bar
     * @return the email user name from the navigation bar
     */
    public String getEmailFromNavBar() {
        return navigationBar.getUserEmail().getText();
    }

    /**
     * This opens the Account Settings page via the Navigation Bar
     */
    public void openAccountSettings() {
        navigationBar.openAccountSettingsPage();
    }

    /**
     * This logs out of Hudl via the Navigation Bar
     */
    public void logOut() {
        navigationBar.logOut();
    }
}
