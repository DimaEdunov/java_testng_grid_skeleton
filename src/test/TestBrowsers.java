import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static org.openqa.selenium.By.xpath;


public class TestBrowsers extends BaseTestSetUpTearDown {

    @Test(groups = "sanity")
    public void testEdgeBrowser() throws InterruptedException {
        driver.get("https://google.co.il");

        try {
            // Set up WebDriverWait with a 10-second timeout
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait until the button is clickable (can also use visibility, presence, etc.)
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(xpath("(//textarea)[1]")));
            button.click();

            // Save the screenshot of SPECIFIC ELEMENT
            File screenshotOfButton = button.getScreenshotAs(OutputType.FILE);

            File destinationPath = new File("C:/selenium-screenshots/button-screenshot.png");
            FileUtils.copyFile(screenshotOfButton, destinationPath);

            File pageScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(pageScreenshot, new File("C:/selenium-screenshots/screen-screenshot.png"));




            System.out.println("Screenshot saved at: " + destinationPath.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }




        Thread.sleep(3000);
    }

    @Test(groups = "sanity")
    public void testChromeBrowser() throws InterruptedException {
        // Close previous driver instance if necessary


        driver.manage().window().maximize();
        driver.get("https://www.ynet.co.il");
        Thread.sleep(3000);
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
