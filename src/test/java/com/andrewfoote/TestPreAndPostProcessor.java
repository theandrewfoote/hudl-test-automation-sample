package com.andrewfoote;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestPreAndPostProcessor extends RunListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestPreAndPostProcessor.class);

    /**
     * Called before any tests start
     */
    public void testRunStarted(Description description) {
        LOGGER.info("Number of tests to execute : " + description.testCount());
    }

    /**
     * Called when the full test execution ends
     */
    public void testRunFinished(Result result) {
        LOGGER.info("Number of tests executed : " + result.getRunCount());
    }

    /**
     * Called before an individual starts
     */
    public void testStarted(Description description) {
        LOGGER.info("Starting execution of test case : " + description.getMethodName());
    }

    /**
     * Called after an individual test ends
     */
    public void testFinished(Description description) {
        LOGGER.info("Finished execution of test case : " + description.getMethodName());
    }

    /**
     * Called when an individual test fails
     */
    public void testFailure(Failure failure) throws java.lang.Exception {
        LOGGER.info("Execution of test case failed : " + failure.getMessage());
    }
}
