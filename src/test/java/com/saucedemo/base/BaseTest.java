package com.saucedemo.base;

//Testing
import com.saucedemo.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.saucedemo.driver.DriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    protected WebDriver driver;


    @BeforeEach
    public void setUp() {

        String browser = ConfigReader.get("browser");

        if (browser.equalsIgnoreCase("chrome")) {

        	WebDriverManager.chromedriver().setup();

        	ChromeOptions options = new ChromeOptions();

        	options.addArguments("--headless=new");
        	options.addArguments("--no-sandbox");
        	options.addArguments("--disable-dev-shm-usage");
        	options.addArguments("--window-size=1920,1080");

        	driver = new ChromeDriver(options);

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