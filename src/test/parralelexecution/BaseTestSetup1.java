package parralelexecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTestSetup1 {
    protected static WebDriver driver;

    @BeforeMethod(groups = "ParralelRun")
    @Parameters({"browser", "node"})
    public static void beforeMethod(String browser, String node) throws MalformedURLException {
        System.out.println("Before Method");
        System.out.println("Browser from config: " + browser);
        System.out.println("Node from config: " + node + "\n");

        if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
        } else {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", browser);
            driver = new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // Increase timeout
        System.out.println("Driver initialized: " + (driver != null));
    }

    @AfterMethod(groups = "ParralelRun")
    public static void afterMethod() {
        System.out.println("After Suite");
        if (driver != null) {
            driver.quit();
        }
    }
}