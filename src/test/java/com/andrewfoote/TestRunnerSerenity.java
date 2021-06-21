package com.andrewfoote;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import java.io.IOException;

public class TestRunnerSerenity extends CucumberWithSerenity {

    public TestRunnerSerenity(Class clazz) throws InitializationError, IOException {
        super(clazz);
    }

    @Override
    public void run(RunNotifier notifier) {
        //Add a listener for pre and post test actions if necessary
        notifier.addListener(new TestPreAndPostProcessor());
        super.run(notifier);
    }
}
