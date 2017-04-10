package com.yourcompany.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.util.NoSuchElementException;


public class BasePageObject {

    protected WebDriver driver;

    private By firstRepeatedText = By.xpath("/html/body/div[2]");
    private By secondRepeatedText = By.xpath("/html/body/div[3]");
    private By thirdRepeatedText = By.xpath("/html/body/div[4]");

    private static String url = "https://saucelabs-sample-test-frameworks.github.io/training-test-page";

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void visitPage() {
        driver.get(url);
    }    

    public void waitForElementToBePresent(String locator) {
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.or(
    	ExpectedConditions.presenceOfElementLocated(By.id(locator)) //,
    	//ExpectedConditions.visibilityOfElementLocated(By.id(locator))
	));        
    }

    public void click(String locator) {
        this.waitForElementToBePresent(locator);
	driver.findElement(By.id(locator)).click();
    }

    public void sendKeys(String locator, String text) {
        this.waitForElementToBePresent(locator);
        driver.findElement(By.id(locator)).sendKeys(text);
    }

    private boolean existsElement(By element) {
    	try {
        	driver.findElement(element);
    	} catch (NoSuchElementException e) {
        	return false;
    	}
    	return true;
    }

    public boolean checkForRepeatedTexts() {
        return this.existsElement(firstRepeatedText) 
		&& this.existsElement(secondRepeatedText) 
			&& this.existsElement(thirdRepeatedText);
    }


}
