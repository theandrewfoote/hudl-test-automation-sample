package com.andrewfoote.pageobjects;

import org.openqa.selenium.Cookie;

/**
 * Utils is a set of general methods to support automation of Hudl.com
 */
public class Utils extends HudlWebsiteHome {

    public Utils() {
        this.getDriver();
    }

    /**
     * This removes a cookie with the specified name from the browser for hudl.com
     * @param cookieNameToDelete - the name of the individual cookie to delete
     */
    public void clearCookieByName(String cookieNameToDelete) {
        getDriver().manage().deleteCookieNamed(cookieNameToDelete);
    }

    /**
     * This checks whether a cookie with the name specified exists or not
     * @param cookieExpectedNotToExist - name of the cookie to check
     * @return true/false whether cookie exists or not
     */
    public boolean doesCookieExist(String cookieExpectedNotToExist) {
        Cookie deletedCookie = getDriver().manage().getCookieNamed(cookieExpectedNotToExist);
        return deletedCookie != null ? true : false;
    }
}
