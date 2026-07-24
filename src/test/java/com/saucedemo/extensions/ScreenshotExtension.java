package com.saucedemo.extensions;

import com.saucedemo.driver.DriverManager;

import io.qameta.allure.Allure;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;


public class ScreenshotExtension implements AfterTestExecutionCallback {


    @Override
    public void afterTestExecution(ExtensionContext context) {


        if (context.getExecutionException().isPresent()) {


            WebDriver driver = DriverManager.getDriver();


            System.out.println("Screenshot Driver: " + driver);


            if (driver != null) {


                byte[] screenshot =
                        ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);


                Allure.addAttachment(
                        "Screenshot - " + context.getDisplayName(),
                        new ByteArrayInputStream(screenshot)
                );


                Allure.addAttachment(
                        "Error Message",
                        context.getExecutionException()
                               .get()
                               .getMessage()
                );
            }
        }
    }
}