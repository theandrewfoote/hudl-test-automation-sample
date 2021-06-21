package com.andrewfoote.steps.actionsteps;

import com.andrewfoote.pageobjects.LoginPage;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LoginActionSteps contains methods to interact with log in functionality on the Hudl web application
 */
public class LoginActionSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginActionSteps.class);

    private LoginPage loginPage = new LoginPage();

    @Step
    public void logIn(String username, String password) {
        logIn(username, password, false);
    }

    @Step
    public void logIn(String username, String password, boolean rememberMe) {
        LOGGER.info(String.format("Running Step to log in with username: %s and password (not exposing)", username));
        loginPage.goTo();
        loginPage.logIn(username, password, rememberMe, "click");
    }

    @Step
    public void logInWithEnterKey(String username, String password) {
        LOGGER.info(String.format("Running Step to log in with username: %s and password (not exposing) and pressing ENTER on keyboard",
                username));
        loginPage.goTo();
        loginPage.logIn(username, password, false, "enter");
    }

    @Step
    public void needHelp() {
        LOGGER.info("Running Step to open the Need Help option");
        loginPage.openNeedHelp();
    }

    @Step
    public void enterUsername(String username) {
        LOGGER.info(String.format("Running Step to enter just the username: %s", username));
        enterCredentials(username, "");
    }

    @Step
    public void goToLoginPage() {
        LOGGER.info("Running Step to go to the log-in page");
        loginPage.goTo();
    }

    @Step
    public void enterCredentials(String username, String password) {
        LOGGER.info(String.format("Running Step to enter just username: %s and password (not exposing)", username));
        loginPage.typeCredentials(username, password);
    }

}
