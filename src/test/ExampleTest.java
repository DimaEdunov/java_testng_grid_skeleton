import org.testng.Assert;
import org.testng.annotations.*;

public class ExampleTest {

    @BeforeMethod
    public void setUp() {
        System.out.println("Opening Browser");
    }

    @Test(priority = 1, groups = "regression")
    public void testExampleOne(){
        System.out.println("Test1 running here");
        String expected = "this title is expected";
        String actual = "this title is expected1";

//        Assert.assertEquals(expected, actual,"This title assertion failed!");
        try{
            System.out.println(expected);
            Assert.fail("This didn't work");

        }
        catch(Throwable e){

        }
    }

    @Test(priority = 2, groups = "regression")
    public void testExampleTwo(){
        System.out.println("Test2 running here");

    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Closing Browser");
    }
}
