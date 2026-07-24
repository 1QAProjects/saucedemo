package com.saucedemo.base;

import com.saucedemo.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.saucedemo.driver.DriverManager;

public class BaseTest {

    protected WebDriver driver;


    @BeforeEach
    public void setUp() {

        String browser = ConfigReader.get("browser");

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            DriverManager.setDriver(driver);

        } else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            DriverManager.setDriver(driver);

        } else if (browser.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            DriverManager.setDriver(driver);

        } else {

            throw new RuntimeException(
                    "Browser not supported: " + browser
            );
        }


        driver.manage().window().maximize();

        driver.get(ConfigReader.get("app.url")
        		
        		
        );
    }

    @AfterEach
    public void tearDown() {

        DriverManager.quitDriver();
    }
  
    
}