package BaseElements;

import Core.TAEBaseObject;
import Core.TAEDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseAbstractPage extends TAEBaseObject {
    protected TAEDriver driver;

    public BaseAbstractPage(TAEDriver driver, String title) {
        this.driver = driver;
        waitIsDisplayed(title, DEFAULT_TIMEOUT, DEFAULT_SLEEP);
    }

    public boolean waitIsDisplayed(String title, int timeout, int sleep) {
        return new WebDriverWait(driver.getDriver(), timeout, sleep).until(ExpectedConditions.titleIs(title));
    }
}
