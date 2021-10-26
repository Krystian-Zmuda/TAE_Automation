package BaseControlls;

import Core.TAEBaseObject;
import Core.TAEDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseControl extends TAEBaseObject {
    protected TAEDriver driver;
    protected By locator;
    protected String name;

    public BaseControl(String name, TAEDriver driver, By locator) {
        this.name = name;
        this.driver = driver;
        this.locator = locator;
    }

    public BaseControl(String name, TAEDriver driver, String xpath) {
        this.name = name;
        this.driver = driver;
        this.locator = By.xpath(xpath);
    }

    public void click(int timeout) {
        new WebDriverWait(driver.getDriver(), timeout, DEFAULT_SLEEP).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        driver.getElement(locator).click();
    }

    public void click() {
        click(DEFAULT_TIMEOUT);
    }
}
