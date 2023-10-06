package listeners;

import utilities.FileManager;
import utilities.Logs;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        Logs.debug("on test start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logs.debug("on test success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Logs.debug("on test failure");
        FileManager.getScreenshot(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logs.debug("on test skipped");
    }
}
