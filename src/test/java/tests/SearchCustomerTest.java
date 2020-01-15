package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchCustomerTest extends PageProvider {
    @When("I redirect to customer page")
    public void redirectToCustomerManagementPage() throws InterruptedException {
        Thread.sleep(2000);
        getSearchCustomerPage().redirectToCustomerManagementPage();
    }

    @And("^I type (.+) to search$")
    public void typeWordToSearch(String searchWord) throws InterruptedException {
        Thread.sleep(3000);
        getSearchCustomerPage().typeWordToSearch(searchWord);
    }

    @Then("^I verify search (.+) information showing successfully$")
    public void verifySearchSuccessfully(String searchWord) {
        getSearchCustomerPage().verifySearchSuccessfully(searchWord, true);
    }
}
