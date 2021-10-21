package com.epam.testproject.ui.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure");
        WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
        attachScreenShot(driver);
    }

    @Attachment(type = "image/png", value = "screenshot")
    private byte[] attachScreenShot(WebDriver driver) {
        System.out.println("attachScreenShot");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish");
    }
}
