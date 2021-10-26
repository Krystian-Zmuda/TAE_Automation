package BaseTest;

import Core.TAEBaseObject;
import Core.TAEDriver;
import Core.TestListener;
import Entities.WebDriverType;
import TAExceptions.TAUnknownBrowserException;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)

public abstract class BaseAbstractTest extends TAEBaseObject {
    private TAEDriver driver;

    public BaseAbstractTest(String browser) throws TAUnknownBrowserException {
        switch (browser) {
            case "chrome": driver = new TAEDriver(WebDriverType.CHROME); break;
            case "firefox": driver = new TAEDriver(WebDriverType.FIREFOX); break;
            case "edge": driver = new TAEDriver(WebDriverType.EDGE); break;
            default: throw new TAUnknownBrowserException(String.format("Unknown '%s' browser", browser));
        }
    }

    public TAEDriver getDriver() {
        return driver;
    }

    private String getClassName() {
        String[] nameLines = this.getClass().toString().split("\\.");
        return nameLines[nameLines.length - 1];
    }

    @BeforeClass
    public void beforeClass(ITestContext iTestContext) {
        iTestContext.setAttribute("driver", driver);
        getLogger().info(String.format("     ***** Start executing class '%s' *****     ", getClassName()));
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}
