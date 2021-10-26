package Core;

import Entities.WebDriverType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.security.Policy;

public class TAEDriver extends TAEBaseObject {
    private WebDriver driver;
    private WebDriverType driverType;

    public TAEDriver(WebDriverType driverType) {
        this.driverType = driverType;
        if(driverType == WebDriverType.CHROME) {
            configureChromeDriver();
            runChromeDriver();
        } else if (driverType == WebDriverType.FIREFOX) {
            runFirefoxDriver(false);
        } else if(driverType == WebDriverType.EDGE) {
            runEdgeDriver(false);
        }
        else {
            throw new WebDriverException(String.format("Not configured driver type %s. ", driverType.getDriverName()));
        }
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quit() {
        driver.quit();
    }

    public WebElement getElement(By by) {
        return driver.findElement(by);
    }

    public WebElement getElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public void navigateTo(String URL) {
        driver.get(URL);
    }

    private void configureChromeDriver() {
        System.setProperty("headless", "false");
    }

    private void runChromeDriver() {
        String headless = System.getProperty("headless");
        ChromeOptions chromeOptions = new ChromeOptions();
        if(headless.equals("true")) {
            chromeOptions.addArguments("--headless");
        }
        driver = new ChromeDriver(chromeOptions);
    }

    private void runFirefoxDriver(boolean headless) {
        FirefoxOptions ffOptions = new FirefoxOptions();
        if(headless) {
            ffOptions.addArguments("--headless");
        }
        driver = new FirefoxDriver(ffOptions);
    }

    public void runEdgeDriver(boolean headless) {
        EdgeOptions edgeOptions = new EdgeOptions();
        /*if(headless) {
            edgeOptions.setCapability("UseChromium", true);
            edgeOptions.addArguments("headless");
        }*/
        driver = new EdgeDriver(edgeOptions);
    }
}
