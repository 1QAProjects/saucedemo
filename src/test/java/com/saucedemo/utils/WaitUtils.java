package com.saucedemo.utils;

import com.saucedemo.constants.FrameworkConstants;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private WebDriver driver;
    private WebDriverWait wait;


    public WaitUtils(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        FrameworkConstants.EXPLICIT_WAIT
                )
        );
    }


    // Wait for element visibility
    public WebElement waitForVisibility(WebElement element) {

        return wait.until(
                ExpectedConditions.visibilityOf(element)
        );
    }


    // Wait for element clickable
    public WebElement waitForClickable(WebElement element) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(element)
        );
    }


    // Wait for element to be displayed
    public boolean waitForDisplay(WebElement element) {

        return wait.until(
                ExpectedConditions.visibilityOf(element)
        ).isDisplayed();
    }


    // Wait for page title
    public boolean waitForTitle(String title) {

        return wait.until(
                ExpectedConditions.titleContains(title)
        );
    }
}