import BaseTest.BaseAbstractChromeTest;
import BaseTest.BaseAbstractTest;
import TAExceptions.TAUnknownBrowserException;
import org.testng.annotations.Test;

public class Test1 extends BaseAbstractTest {
    public Test1(String browser) throws TAUnknownBrowserException {
        super("chrome");
    }


    @Test
    public void test() {
        int a = 5+6;
    }
}
