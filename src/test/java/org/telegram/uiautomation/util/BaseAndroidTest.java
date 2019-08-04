package org.telegram.uiautomation.util;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseAndroidTest {
    public static AndroidDriver<AndroidElement> driver;
    private static String APPIUM_SERVER = "http://localhost:4723/wd/hub";
    private static String APP_PACKAGE = "org.telegram.messenger";

    public static void initDriver() throws MalformedURLException {
        File appDir = new File("src/test/resources");
        File app = new File(appDir, "apk/telegram.apk");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", APP_PACKAGE);
        caps.setCapability("newCommandTimeout", "3600");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        //caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0.0");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE);
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.telegram.ui.LaunchActivity");

        URL url = new URL(APPIUM_SERVER);
        driver = new AndroidDriver<AndroidElement>(url, caps);

    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }

    }
}
