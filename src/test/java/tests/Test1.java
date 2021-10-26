package tests;

import BaseTest.BaseAbstractChromeTest;
import TAExceptions.TAUnknownBrowserException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test1 extends BaseAbstractChromeTest {
    public Test1() throws TAUnknownBrowserException{
    }

    @Test
    public void test() {
        getDriver().getDriver().get("https://www.phptravels.net/");
        Assert.assertTrue(false);
    }
}
