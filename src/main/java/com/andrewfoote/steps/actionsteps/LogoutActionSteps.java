package com.andrewfoote.steps.actionsteps;

import com.andrewfoote.pageobjects.HudlHome;
import com.andrewfoote.pageobjects.Utils;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LogoutActionSteps contains methods to interact with log out functionality on the Hudl web application
 */
public class LogoutActionSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogoutActionSteps.class);

    private Utils utils = new Utils();
    private HudlHome hudlHome = new HudlHome();

    @Step
    public void clearLoggedInUser() {
        LOGGER.info("Running Step to clear the ident cookie");
        utils.clearCookieByName("ident");
    }

    @Step
    public void logOut() {
        LOGGER.info("Running Step to log out");
        hudlHome.logOut();
    }
}
