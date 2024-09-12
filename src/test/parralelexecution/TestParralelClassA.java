package parralelexecution;

import org.testng.annotations.Test;

public class TestParralelClassA extends BaseTestSetup1 {

    @Test(groups = "ParralelRun")
    public void testChromeBrowserA() {
        driver.get("http://www.example.com");
        System.out.println("Test Chrome Browser A - Title: " + driver.getTitle());
    }

    @Test(groups = "ParralelRun")
    public void testEdgeBrowserA() {
        driver.get("http://www.example.com");
        System.out.println("Test Edge Browser A - Title: " + driver.getTitle());
    }
}