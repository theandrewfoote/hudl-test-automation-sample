package com.andrewfoote.stepdefinitions;

import com.andrewfoote.steps.actionsteps.LoginActionSteps;
import com.andrewfoote.steps.actionsteps.LogoutActionSteps;
import com.andrewfoote.steps.assertionsteps.LoginAssertionSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginStepDefs {

    private static final String VALID_USERNAME = System.getProperty("hudl.username");
    private static final String VALID_PASSWORD = System.getProperty("hudl.password");

    @Steps
    LoginActionSteps loginActionSteps;

    @Steps
    LoginAssertionSteps loginAssertionSteps;

    @Steps
    LogoutActionSteps logoutActionSteps;

    @When("^logging in to Hudl with valid credentials$")
    public void userIsLoggedIn() {
        loginActionSteps.logIn(VALID_USERNAME, VALID_PASSWORD);
    }

    @Given("^a valid user is logged into Hudl$")
    public void clearPreviousLoggedInUserAndLogInWithValidCredentials() {
        logoutActionSteps.clearLoggedInUser();
        loginActionSteps.logIn(VALID_USERNAME, VALID_PASSWORD);
    }

    @Then("^the user's email address is displayed in the navigation bar and in account settings$")
    public void theUserSEmailAddressIsDisplayedInTheNavigationBarAndInAccountSettings() {
        loginAssertionSteps.verifyUserLoggedIn(VALID_USERNAME);
        loginAssertionSteps.verifyUserEmailInAccountSettings(VALID_USERNAME);
    }

    @When("^logging in to Hudl with an incorrect password$")
    public void loggingInToHudlWithAnInvalidPassword() {
        String validUsername = VALID_USERNAME;
        String invalidPassword = "ExampleIncorrectPassword1";
        loginActionSteps.logIn(validUsername, invalidPassword);
    }

    @Then("^the user is informed that the log-in failed$")
    public void theUserIsInformedThatTheLogInFailed() {
        loginAssertionSteps.verifyLogInErrorMessageIsShown();
    }

    @When("^logging in to Hudl with a non-existent username$")
    public void loggingInToHudlWithANonExistentUsername() {
        String incorrectUsername = "NonExistentUsername";
        String password = "ExampleIncorrectPassword1";
        loginActionSteps.logIn(incorrectUsername, password);
    }

    @When("^logging in to Hudl with a blank password$")
    public void loggingInToHudlWithABlankPassword() {
        loginActionSteps.logIn(VALID_USERNAME, "");
    }

    @When("^seeking help to log in$")
    public void seekingHelpToLogIn() {
        loginActionSteps.goToLoginPage();
        loginActionSteps.needHelp();
    }

    @Then("^the user is informed of how to progress$")
    public void theUserIsInformedOfHowToProgress() {
        loginAssertionSteps.verifyLoginHelpTitle();
    }

    @When("^seeking help to log in having entered a username$")
    public void seekingHelpToLogInHavingEnteredAUsername() {
        loginActionSteps.goToLoginPage();
        loginActionSteps.enterUsername(VALID_USERNAME);
        loginActionSteps.needHelp();
    }

    @Then("^the email address is persisted on the login screen$")
    public void theEmailAddressIsPersistedOnTheLoginScreen() {
        loginAssertionSteps.verifyForgotEmailAddressPopulated(VALID_USERNAME);
    }

    @When("^logging in to Hudl with Remember Me selected and logging out$")
    public void loggingInToHudlWithRememberMeSelectedAndLoggingOut() {
        loginActionSteps.logIn(VALID_USERNAME, VALID_PASSWORD, true);
        logoutActionSteps.logOut();
    }

    @Then("^the user's email address is prefilled as the username$")
    public void theUserSEmailAddressIsPrefilledAsTheUsername() {
        loginActionSteps.goToLoginPage();
        loginAssertionSteps.verifyEmailAddressPopulated(VALID_USERNAME);
    }

    @When("^preparing to log in with valid credentials$")
    public void preparingToLogInWithValidCredentials() {
        loginActionSteps.goToLoginPage();
        loginActionSteps.enterCredentials(VALID_USERNAME, VALID_PASSWORD);
    }

    @Then("^the password field is of type password$")
    public void thePasswordFieldIsOfTypePasswordAndTheTextCannotBeRead() {
        loginAssertionSteps.verifyPasswordInputFieldType();
    }

    @When("^logging in to Hudl with valid credentials using just the keyboard$")
    public void loggingInToHudlWithValidCredentialsUsingJustTheKeyboard() {
        loginActionSteps.logInWithEnterKey(VALID_USERNAME, VALID_PASSWORD);
    }
}
