package parameterizationtests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestParameterizationFromXml {

    @Test (groups = "parameterization")
    @Parameters("browser")
    public void getBrowser (String browser) {
        System.out.println("Got parameter frmo .xml : " + browser);
        System.out.println("This test is parameterizied by XML");

    }
}
