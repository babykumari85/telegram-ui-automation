package org.telegram.uiautomation.util;

import org.telegram.uiautomation.pages.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTest extends BaseAndroidTest {
    private HomePage homePage;

    @BeforeClass
    public void init() throws MalformedURLException {
        BaseAndroidTest.initDriver();
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void close(){
        BaseAndroidTest.quitDriver();
    }

    @Test
    public void startMessagingButtonShouldBeVisible() throws InterruptedException {
        Thread.sleep(2000);
        assertTrue(homePage.isStartMessagingBtnVisible());
        assertEquals(homePage.startMessaging().getText(), "START MESSAGING");
    }

    @Test(dependsOnMethods={"startMessagingButtonShouldBeVisible"})
    public void verificationActivityShouldOpen() throws InterruptedException {
        homePage.clickStartMessagingBtn();
        Thread.sleep(2000);
        assertTrue(homePage.isOtpVerificationInstructionVisible());
    }
}
