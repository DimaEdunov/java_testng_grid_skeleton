import org.testng.SkipException;
import org.testng.annotations.Test;

public class SkipTestExample {

    @Test
    public void skipTestExample() {
        int number = 1;

        if (number == 1) {
            throw new SkipException("Skip this test because conditions is not met");
        }
    }
}
