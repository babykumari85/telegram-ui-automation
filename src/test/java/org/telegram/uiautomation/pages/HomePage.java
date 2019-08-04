package org.telegram.uiautomation.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomePage {
    private AndroidDriver<AndroidElement> driver;

    public HomePage(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
    }

    public AndroidElement startMessaging(){
        return driver.findElementsByClassName("android.widget.TextView").get(2);
    }

    public boolean isOtpVerificationInstructionVisible(){
        return driver.findElementsByClassName("android.widget.TextView").get(3).getText()
                .equals("Please confirm your country code and enter your phone number.");
    }

    public boolean isStartMessagingBtnVisible(){
        return startMessaging().isDisplayed();
    }

    public void clickStartMessagingBtn(){
        startMessaging().click();
    }

}
