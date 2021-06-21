package com.andrewfoote.pageobjects;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

/**
 * LoginPage represents the login page to Hudl.com
 */
public class LoginPage extends HudlWebsiteHome {

    /**
     * LoginPage constructor to set up Webdriver
     */
    public LoginPage() {
        this.getDriver();
    }

    @FindBy(id = "email")
    private WebElementFacade usernameInput;

    @FindBy(id = "password")
    private WebElementFacade passwordInput;

    @FindBy(id = "logIn")
    private WebElementFacade submitButton;

    @FindBy(css = "body > div.super-wrap > form.login-container > div.login-error.fade-in-expand > div > p")
    private WebElementFacade loginErrorMessage;

    @FindBy(id = "forgot-password-link")
    private WebElementFacade needHelpLink;

    @FindBy(css = "body > div.super-wrap > form.reset-container > div.reset-info > h1")
    private WebElementFacade loginHelpTitle;

    @FindBy(id = "forgot-email")
    private WebElementFacade forgotEmailInput;

    @FindBy(id = "remember-me")
    private WebElementFacade rememberMeSelect;

    //Actions
        // Each action is based on the assumption the UI is on the log-in screen, with the exception of the goTo() method
    /**
     * This navigates to the log in page
     */
    public void goTo() {
        super.goToLoginPage();
    }

    /**
     * This logs into Hudl
     * @param username - the username to log in with
     * @param password - the password to log in with
     * @param rememberMe - true/false whether to select Remember Me
     * @param clickOrEnter - click/enter whether to use mouse or keyboard to login
     */
    public void logIn(String username, String password, boolean rememberMe, String clickOrEnter){
        typeCredentials(username, password);
        boolean notChecked = !rememberMeSelect.isSelected() && rememberMe;
        boolean notToRemember = rememberMeSelect.isSelected() && !rememberMe;
        if(notChecked || notToRemember) {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(rememberMeSelect).click().perform();
        }
        if(clickOrEnter.equals("enter")) {
            passwordInput.sendKeys(Keys.ENTER);
        }
        else {
            submitButton.click();
        }
    }

    /**
     * This enters the credentials in the login page
     * @param username - username to log in with
     * @param password - password to log in with
     */
    public void typeCredentials(String username, String password) {
        usernameInput.clear();
        passwordInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }

    /**
     * This opens the Need Help option in the login page
     */
    public void openNeedHelp() {
        needHelpLink.click();
    }

    /**
     * This returns the login error message
     * @return login error message shown in UI
     */
    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }

    /**
     * This returns the login help title
     * @return login help title
     */
    public String getLoginHelpTitle() {
        return loginHelpTitle.getText();
    }

    /**
     * This returns the email address shown in the Forgot Email field
     * @return email address shown in forgot email field
     */
    public String getForgotEmailValue() {
        return forgotEmailInput.getAttribute(VALUE_ATTRIBUTE_TEXT);
    }

    /**
     * This returns the username value from the login page
     * @return username visible in the login page
     */
    public String getUsernameValue() {
        return usernameInput.getAttribute(VALUE_ATTRIBUTE_TEXT);
    }

    /**
     * This returns the password value from the login page
     * @return password in login page
     */
    public String getPasswordFieldType() {
        return passwordInput.getAttribute("type");
    }

}
