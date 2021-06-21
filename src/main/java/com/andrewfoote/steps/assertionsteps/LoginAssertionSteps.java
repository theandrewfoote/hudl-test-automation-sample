package com.andrewfoote.steps.assertionsteps;

import com.andrewfoote.pageobjects.AccountSettingsPage;
import com.andrewfoote.pageobjects.HudlHome;
import com.andrewfoote.pageobjects.LoginPage;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * LoginAssertionSteps contains methods to verify the login process of the Hudl web application
 */
public class LoginAssertionSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginAssertionSteps.class);

    private HudlHome hudlHome = new HudlHome();
    private AccountSettingsPage accountSettingsPage = new AccountSettingsPage();
    private LoginPage loginPage = new LoginPage();

    private static final String EXPECTED_LOGIN_ERROR_MESSAGE = "We didn't recognize that email and/or password";
    private static final String EXPECTED_LOGIN_HELP_TEXT  = "Login Help";
    private static final String EXPECTED_PASSWORD_FIELD_TYPE = "password";

    @Step
    public void verifyUserLoggedIn(String expectedEmailAddress) {
        LOGGER.info(String.format("Running Step to verify user's email in nav bar is %s", expectedEmailAddress));
        assertThat(hudlHome.getEmailFromNavBar(), containsString(expectedEmailAddress));
    }

    @Step
    public void verifyUserEmailInAccountSettings(String expectedEmailAddress) {
        LOGGER.info(String.format("Running Step to verify user's email in account settings is %s", expectedEmailAddress));
        hudlHome.openAccountSettings();
        assertThat(accountSettingsPage.getEmailAddress(), containsString(expectedEmailAddress));
    }

    @Step
    public void verifyLogInErrorMessageIsShown() {
        String actualLogInError = loginPage.getLoginErrorMessage();
        LOGGER.info(String.format("Running Step to verify that: %s contains %s", actualLogInError, EXPECTED_LOGIN_ERROR_MESSAGE));
        assertThat(actualLogInError, containsString(EXPECTED_LOGIN_ERROR_MESSAGE));
    }

    @Step
    public void verifyLoginHelpTitle() {
        LOGGER.info(String.format("Running Step to verify that the help title is: %s", EXPECTED_LOGIN_HELP_TEXT));
        assertThat(loginPage.getLoginHelpTitle(), containsString(EXPECTED_LOGIN_HELP_TEXT));
    }

    @Step
    public void verifyForgotEmailAddressPopulated(String expectedUsername) {
        LOGGER.info(String.format("Running Step to verify the pre-populate email address is: %s", expectedUsername));
        assertThat(loginPage.getForgotEmailValue(), equalTo(expectedUsername));
    }

    @Step
    public void verifyEmailAddressPopulated(String expectedUsername) {
        LOGGER.info(String.format("Running Step to verify the email field contains: %s", expectedUsername));
        assertThat(loginPage.getUsernameValue(), equalTo(expectedUsername));
    }

    @Step
    public void verifyPasswordInputFieldType() {
        LOGGER.info("Running Step to verify the password field has type password");
        assertThat(loginPage.getPasswordFieldType(), equalTo(EXPECTED_PASSWORD_FIELD_TYPE));
    }
}
