import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseTestSetUpTearDown {
    protected static WebDriver driver;

    @BeforeSuite(groups = "sanity")
    public static void beforeSuite() {
        System.out.println("Before Suite");

        // Initialize WebDriver for Edge or Chrome as needed
        // Uncomment the respective lines if you use WebDriverManager
        // WebDriverManager.edgedriver().setup();
        // WebDriverManager.chromedriver().setup();

        // Example for Edge:
        System.out.println("Setting up WebDriver instance");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        System.out.println("Driver initialized: " + (driver != null));
    }


@AfterSuite(groups = "sanity")
public static void afterSuite() {
    System.out.println("After Suite");

}
}
