package tests;

import cucumber.api.java.en.Then;

import static tests.PageProvider.getOpenWebsitePage;

public class OpenWebsiteTest {
    @Then("^I verify open website successfully$")
    public void verifyOpenWebsite() throws InterruptedException {
        Thread.sleep(3000);
        getOpenWebsitePage().verifyOpenWebsite();
    }
}
