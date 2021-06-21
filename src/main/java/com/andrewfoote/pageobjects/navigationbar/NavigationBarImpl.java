package com.andrewfoote.pageobjects.navigationbar;

import com.andrewfoote.pageobjects.BaseComponent;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public class NavigationBarImpl extends BaseComponent implements NavigationBar {

    public NavigationBarImpl(WebDriver driver, ElementLocator locator, WebElement webElement, long implicitTimeoutInMilliseconds) {
        super(driver, locator, webElement, implicitTimeoutInMilliseconds);
    }

    @FindBy(css = ".hui-globaluseritem__email")
    private WebElementFacade userEmail;

    @FindBy(css = ".hui-globalusermenu")
    private WebElementFacade navBarMenu;

    @FindBy(css = "a[data-qa-id='webnav-usermenu-accountsettings']")
    private WebElementFacade accountSettingsMenuOption;

    @FindBy(css = "a[data-qa-id='webnav-usermenu-logout']")
    private WebElementFacade logoutMenuOption;

    @Override
    public WebElementFacade getUserEmail() {
        Actions action = new Actions(driver);
        action.moveToElement(navBarMenu).perform();
        return userEmail;
    }

    @Override
    public void openAccountSettingsPage() {
        Actions action = new Actions(driver);
        action.moveToElement(navBarMenu).perform();
        accountSettingsMenuOption.click();
    }

    @Override
    public void logOut() {
        Actions action = new Actions(driver);
        action.moveToElement(navBarMenu).perform();
        logoutMenuOption.click();
    }

}
