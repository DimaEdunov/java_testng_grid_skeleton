package allurreport;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import parralelexecution.BaseTestSetup1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Epic("Allure Report Tests")
public class TestAllureReport extends BaseTestSetup1 {

    @Test
    @Description("This test will pass and attach a screenshot to the Allure report")
    public void AllureTest1Pass() throws InterruptedException {
        System.out.println("Allure Test #1");

        driver.get("https://google.co.il");
        Thread.sleep(3000);

        step1();
        step2();

        // Take a screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("C:/selenium-screenshots/test1-screenshot.png"));
            System.out.println("Screenshot saved at: C:/selenium-screenshots/test1-screenshot.png");

            // Attach screenshot to Allure report
            try (FileInputStream fis = new FileInputStream(screenshot)) {
                Allure.addAttachment("Screenshot", fis);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.fail();
    }

    @Step("Step 1: Perform the first step")
    public void step1() {
        System.out.println("Executing Step 1");
    }

    @Step("Step 2: Perform the second step")
    public void step2() {
        System.out.println("Executing Step 2");
    }

    @Test
    @Description("This test will fail")
    public void AllureTest2Fail() {
        System.out.println("Allure Test #2");
        Assert.fail();
    }

    @Test
    @Description("This test will be skipped")
    public void AllureTest3Exception() {
        System.out.println("Allure Test #3");
        throw new SkipException("Skipping this test with SkipException");
    }
}