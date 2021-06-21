package com.andrewfoote.steps.assertionsteps;

import com.andrewfoote.pageobjects.HudlWebsiteHome;
import com.andrewfoote.pageobjects.Utils;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * BaseAssertionSteps contains methods to verify generic parts of the Hudl web application
 */
public class BaseAssertionSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseAssertionSteps.class);

    private Utils utils = new Utils();
    private HudlWebsiteHome hudlWebsiteHome = new HudlWebsiteHome();

    @Step
    public void verifyCookieDoesNotExist(String cookieExpectedNotToExist) {
        LOGGER.info(String.format("Running Step to verify cookie %s does not exist", cookieExpectedNotToExist));
        assertThat(utils.doesCookieExist(cookieExpectedNotToExist), equalTo(false));
    }

    @Step
    public void verifyFrontPageVisible() {
        LOGGER.info("Running Step to verify the home page is displayed");
        assertThat(hudlWebsiteHome.isDisplayed(), equalTo(true));
    }
}
