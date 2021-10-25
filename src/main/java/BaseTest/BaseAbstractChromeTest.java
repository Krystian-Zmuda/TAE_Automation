package BaseTest;

import Entities.WebDriverType;
import TAExceptions.TAUnknownBrowserException;

public class BaseAbstractChromeTest extends BaseAbstractTest{
    public BaseAbstractChromeTest() throws TAUnknownBrowserException {
        super(WebDriverType.CHROME.getDriverName());
    }

}
