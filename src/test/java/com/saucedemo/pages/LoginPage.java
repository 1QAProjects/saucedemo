package com.saucedemo.pages;

import com.saucedemo.utils.WaitUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    private WebDriver driver;
    private WaitUtils waitUtils;


    // Constructor
    public LoginPage(WebDriver driver) {

        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);

        PageFactory.initElements(driver, this);
    }


    // Locators

    @FindBy(id = "user-name")
    private WebElement usernameField;


    @FindBy(id = "password")
    private WebElement passwordField;


    @FindBy(id = "login-button")
    private WebElement loginButton;


    // Actions

    public void enterUsername(String username) {

        waitUtils.waitForVisibility(usernameField).clear();

        usernameField.sendKeys(username);
    }


    public void enterPassword(String password) {

        waitUtils.waitForVisibility(passwordField).clear();

        passwordField.sendKeys(password);
    }


    public void clickLogin() {

        waitUtils
                .waitForClickable(loginButton)
                .click();

    }


    // Complete login flow
    public void login(String username, String password) {

        enterUsername(username);

        enterPassword(password);

        clickLogin();

    }

}