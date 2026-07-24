package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.extensions.ScreenshotExtension;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.ConfigReader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Description;



@ExtendWith(ScreenshotExtension.class)
public class LoginTest extends BaseTest { 


    @Test
    public void verifySuccessfulLogin() {


        // Create Login Page object
        LoginPage loginPage =
                new LoginPage(driver);


        // Perform Login
        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );


        // Verify login successful by URL
        Assertions.assertEquals("Swag Labs", driver.getTitle());

    }

}