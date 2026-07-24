package com.saucedemo.constants;

public final class FrameworkConstants {

    // Prevent object creation
    private FrameworkConstants() {
    }

    // Configuration File
    public static final String CONFIG_FILE_PATH =
            System.getProperty("user.dir")
            + "/src/test/resources/config.properties";

    // Screenshots Folder
    public static final String SCREENSHOT_PATH =
            System.getProperty("user.dir")
                    + "/screenshots/";

    // Reports Folder (for future use)
    public static final String REPORT_PATH =
            System.getProperty("user.dir")
                    + "/reports/";

    // Default Explicit Wait
    public static final int EXPLICIT_WAIT = 10;

    // Default Implicit Wait (optional)
    public static final int IMPLICIT_WAIT = 5;

    // Page Load Timeout
    public static final int PAGE_LOAD_TIMEOUT = 30;
}