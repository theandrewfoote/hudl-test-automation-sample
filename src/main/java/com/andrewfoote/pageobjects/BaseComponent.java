package com.andrewfoote.pageobjects;

import net.serenitybdd.core.pages.AnyPage;
import net.serenitybdd.core.pages.WidgetObjectImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public class BaseComponent extends WidgetObjectImpl implements BaseWebElementFacade {

    protected final WebDriver driver;

    public BaseComponent(WebDriver driver, ElementLocator locator, WebElement webElement, long timeoutInMilliseconds) {
        super(new AnyPage(driver), locator, webElement, timeoutInMilliseconds);
        this.driver = driver;
    }

    @Override
    /**
     * This overriss the Serenity BaseWebElementFacade to support page fragments
     */
    public BaseWebElementFacade findBy(By selector) {
        WebElement nestedElement = getElement().findElement(selector);
        return new BaseComponent(driver, null, nestedElement, timeoutInMilliseconds());
    }
}
