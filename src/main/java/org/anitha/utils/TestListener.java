package org.anitha.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.anitha.base.DriverFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import org.anitha.utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    private ExtentReports extent;

    @Override
    public void onStart(ITestContext context) {

        String path = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle("Amazon Famework Report");
        reporter.config().setReportName("Amazon Test Results");
        reporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Anitha");
        String os = context.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System", os);
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        ExtentManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentManager.getTest().pass("Test Passed" + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentManager.getTest().fail("Test Failed:" + result.getName());
        ExtentManager.getTest().fail("Test Failed:" + result.getThrowable());
        String screenshotPath = ScreenshotUtils.captureScreenshot(DriverFactory.getDriver(), result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {

        ExtentManager.getTest().skip("Test Skipped : " + result.getName());

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}

















