package Core;

import Entities.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TAEDriver extends TAEBaseObject{
    private WebDriver driver;
    private WebDriverType driverType;

    public TAEDriver(WebDriverType driverType){
        this.driverType=driverType;
        if (driverType == WebDriverType.CHROME) {
            configureChromeDriver();
            runChromeDriver();
        }else if (driverType == WebDriverType.FIREFOX) {
            runFirefoxDriver(false);
        }else if (driverType == WebDriverType.EDGE) {
            runEdgeDriver(false);
        } else {
            throw new WebDriverException(String.format("Not configured  driver type %s",driverType.getDriverName()));
        }
    }
    public WebDriver getDriver() {
        return driver;
    }

    public void quit() {
        driver.quit();
    }

    private void configureChromeDriver() {
        System.setProperty("headless", "false");
//        System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
    }
    private void runChromeDriver() {
        String headless = System.getProperty("headless");
        ChromeOptions chromeOptions = new ChromeOptions();
        if (headless.equals("true")) {
            chromeOptions.addArguments("--headless");
        }
        driver = new ChromeDriver(chromeOptions);
    }
    private void runFirefoxDriver(boolean headless) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (headless) {
            firefoxOptions.addArguments("--headless");
        }
        driver = new FirefoxDriver(firefoxOptions);
    }
    private void runEdgeDriver(boolean headless) {
        EdgeOptions edgeOptions = new EdgeOptions();
        if (headless) {
            edgeOptions.addArguments("--headless");
        }
        driver = new EdgeDriver(edgeOptions);
    }
}
