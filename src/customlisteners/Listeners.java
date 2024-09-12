package customlisteners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    public void onTestStart(ITestResult result) {}

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed , Name " +result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("On Test Failure capture screenshot");
    }

    public void onTestSkipped(ITestResult result) {}

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    public void onStart(ITestContext context) {}

    public void onFinish(ITestContext context) {}

    public void onTestFinished(ITestResult result) {}


}
