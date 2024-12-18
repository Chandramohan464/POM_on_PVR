package com.pvr.qa.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pvr.qa.base.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener extends BaseClass implements ITestListener {
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extentReports;
    public ExtentTest test;
    private final String projectPath = System.getProperty("user.dir");

    @Override
    public void onStart(ITestContext context) {

        sparkReporter=new ExtentSparkReporter("C:\\Users\\91886\\IdeaProjects\\PageObjectModelTest\\reports\\ExtentReport.html");

        sparkReporter.config().setDocumentTitle("PVR Extent Report");
        sparkReporter.config().setReportName("Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extentReports=new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test=extentReports.createTest(result.getName());
        test.log(Status.PASS,"Test case is PASSED "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result, projectPath);

        test.fail("Test Failed: " + result.getThrowable().getMessage()).addScreenCaptureFromBase64String(screenshotPath);
        test=extentReports.createTest(result.getName());
        test.log(Status.FAIL,"Test case is FAILED "+result.getName());
        test.log(Status.FAIL,"Test case FAILED cause is "+result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test=extentReports.createTest(result.getName());
        test.log(Status.SKIP,"Test case is SKIPPED "+result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {

        extentReports.flush();
    }
}

