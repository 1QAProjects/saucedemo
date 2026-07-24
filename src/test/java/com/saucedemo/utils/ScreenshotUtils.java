package com.saucedemo.utils;


import com.saucedemo.constants.FrameworkConstants;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtils {


    public static void captureScreenshot(WebDriver driver, String screenshotName) {

        try {

            File source =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);


            File destination =
                    new File(
                            FrameworkConstants.SCREENSHOT_PATH
                            + screenshotName
                            + ".png"
                    );


            // Create folder if not available
            destination.getParentFile().mkdirs();


            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING
            );


        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to capture screenshot", e
            );
        }
    }
}