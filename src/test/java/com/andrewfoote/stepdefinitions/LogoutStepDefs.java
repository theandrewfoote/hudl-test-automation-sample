package com.andrewfoote.stepdefinitions;

import com.andrewfoote.steps.actionsteps.LogoutActionSteps;
import com.andrewfoote.steps.assertionsteps.BaseAssertionSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LogoutStepDefs {

    @Steps
    LogoutActionSteps logoutActionSteps;

    @Steps
    BaseAssertionSteps baseAssertionSteps;

    @Given("^No user is logged in$")
    public void noUserIsLoggedIn() {
        logoutActionSteps.clearLoggedInUser();
    }

    @When("^logging out of Hudl$")
    public void loggingOutOfHudl() {
        logoutActionSteps.logOut();
    }

    @Then("^the user is returned to the Hudl front web page$")
    public void theUserIsReturnedToFrontPagfe() {
        baseAssertionSteps.verifyFrontPageVisible();
    }

    @Then("^cookies that relate to the user who was logged in no longer exist in the browser$")
    public void verifyCookieDoesNotExist() {
        String cookieExpectedNotToExist = "ident";
        baseAssertionSteps.verifyCookieDoesNotExist(cookieExpectedNotToExist);
    }
}
