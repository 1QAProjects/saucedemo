package com.saucedemo.utils;

import com.saucedemo.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;


    // Load configuration file when class is loaded
    static {

        try {

            FileInputStream fileInputStream =
                    new FileInputStream(
                            FrameworkConstants.CONFIG_FILE_PATH
                    );

            properties = new Properties();

            properties.load(fileInputStream);

            fileInputStream.close();

        } catch (IOException e) {

            throw new RuntimeException(
                    "Unable to load config.properties file", e
            );
        }
    }


    // Read value from config.properties
    public static String get(String key) {

        return properties.getProperty(key);

    }
}