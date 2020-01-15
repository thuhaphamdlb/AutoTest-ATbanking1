package tests;

import cucumber.api.java.en.Given;
import runner.TestRunner;

public class CommonTest {
    @Given("Open website (.*)$")
    public void openWebsite(String website) throws InterruptedException {
        Thread.sleep(2000);
        TestRunner.driver.get(website);
        Thread.sleep(3000);
        TestRunner.driver.manage().window().maximize();
    }
}
