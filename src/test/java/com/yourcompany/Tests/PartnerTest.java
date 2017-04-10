package com.yourcompany.Tests;

import com.yourcompany.Pages.BasePageObject;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;

/**
 * Created by dguzman on 09/4/17.
 */

public class PartnerTest extends TestBase {

    /**
     * Runs a simple test verifying all repeated '“i appear 3 times on the page' text.
     *
     * @throws InvalidElementStateException
     */
    @Test(dataProvider = "hardCodedBrowsers")
    public void verifyAllRepeatedTextTest(String browser, String version, String os, Method method)
            throws MalformedURLException, InvalidElementStateException, UnexpectedException {

        //create webdriver session
        this.createDriver(browser, version, os, method.getName());
        WebDriver driver = this.getWebDriver();
        BasePageObject page = new BasePageObject(driver);

        page.visitPage();
        Assert.assertTrue(page.checkForRepeatedTexts(), "There is one o more elements not visible.");
    }

}
