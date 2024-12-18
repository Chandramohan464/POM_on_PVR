package com.pvr.qa.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, ITestResult result, String projectPath) {

        String base64 = null;

        String timestamp = String.valueOf(System.currentTimeMillis());
        String screenshotPath = projectPath + "/screenshots/" + result.getMethod().getMethodName() + "_" + timestamp + ".png";
        try {
            base64=((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File(screenshotPath));
            System.out.println("Screenshot saved: " + screenshotPath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
        return base64;
    }
}
