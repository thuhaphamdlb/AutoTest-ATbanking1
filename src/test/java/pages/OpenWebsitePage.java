package pages;

import org.testng.Assert;
import runner.TestRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OpenWebsitePage {
    public void verifyOpenWebsite() {
        String actualUrl = TestRunner.driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, "https://www.way2automation.com/angularjs-protractor/banking/#/login");
    }
}
