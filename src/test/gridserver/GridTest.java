package gridserver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class GridTest {
    public static void main(String[] args) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "chrome");

            WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

            driver.get("http://www.example.com");
            System.out.println("Title: " + driver.getTitle());
            Thread.sleep(10000);

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}