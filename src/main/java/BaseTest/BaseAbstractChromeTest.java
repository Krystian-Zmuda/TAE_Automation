package BaseTest;

import TAExceptions.TAUnknownBrowserException;

public class BaseAbstractChromeTest extends BaseAbstractTest {
    public BaseAbstractChromeTest() throws TAUnknownBrowserException {
        super("chrome");
    }
}
