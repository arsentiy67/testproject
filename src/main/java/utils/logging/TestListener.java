package utils.logging;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (!result.isSuccess()) {
            iLogger.takeScreenshot();
            iLogger.error("Test failed", result.getThrowable());
        }
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        iLogger.info("Test success " + tr.getTestName());
        iLogger.takeScreenshot();
    }
}

