package com.andrewfoote.pageobjects.navigationbar;

import net.serenitybdd.core.annotations.ImplementedBy;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * NavigationBar represents just the navigation bar on the Hudl.com web application, available on several pages
 */
@ImplementedBy(NavigationBarImpl.class)
public interface NavigationBar extends WebElementFacade {

    WebElementFacade getUserEmail();
    void openAccountSettingsPage();
    void logOut();
}
