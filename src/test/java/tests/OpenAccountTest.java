package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OpenAccountTest extends PageProvider {
    @And("^I redirect to open account page$")
    public void redirectToOpenAccountPage() throws InterruptedException {
        Thread.sleep(2000);
        getOpenAccountPage().redirectToOpenAccountPage();
    }

    @When("^I choose account as (.+) and currency as (.+)$")
    public void openAccount(String fullName, String currency) throws InterruptedException {
        Thread.sleep(2000);
        getOpenAccountPage().getUserInformation(fullName);
        Thread.sleep(2000);
        getOpenAccountPage().getCurrency(currency);
    }

    @And("^I click open account$")
    public void i_click_open_account() throws InterruptedException {
        getOpenAccountPage().clickProcess();
    }

    @Then("^I verify that user is already open$")
    public void verifyUserAlreadyOpen() throws InterruptedException {
        Thread.sleep(2000);
        getOpenAccountPage().verifyUserAlreadyOpen();
    }

}
