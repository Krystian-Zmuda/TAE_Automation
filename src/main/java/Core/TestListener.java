package Core;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

public class TestListener extends TAEBaseObject implements ITestListener {

    ITestContext iTestContext;

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
            getLogger().error(String.format("Test '%s' failed", iTestResult.getName()));
        try {
            makeScreenshot(iTestResult.getName());
        } catch (Exception e) {
            getLogger().error(String.format("Error occurs on saving screenshot: /n%s", e.getMessage()));
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        this.iTestContext = iTestContext;
    }

    @Override
    public void onFinish(ITestContext context) {

    }

    private void makeScreenshot(String testName) throws IOException {
        TAEDriver driver = (TAEDriver) iTestContext.getAttribute("driver");
        File screenshot =((TakesScreenshot) driver.getDriver()).getScreenshotAs(OutputType.FILE);
        File newFile = new File(System.getProperty("user.dir") + String.format("/target/test-output/screenshots/%s_%s.png", testName, new Date().getTime()));
        Files.copy(screenshot.toPath(), newFile.toPath());
    }
}
