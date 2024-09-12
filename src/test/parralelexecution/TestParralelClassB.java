package parralelexecution;

import org.testng.annotations.Test;

public class TestParralelClassB extends BaseTestSetup1 {

    @Test(groups = "ParralelRun")
    public void testChromeBrowserB() {
        driver.get("http://www.example.com");
        System.out.println("Test Chrome Browser B - Title: " + driver.getTitle());
    }

    @Test(groups = "ParralelRun")
    public void testEdgeBrowserB() {
        driver.get("http://www.example.com");
        System.out.println("Test Edge Browser B - Title: " + driver.getTitle());
    }
}