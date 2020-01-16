package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeleteCustomerTest extends PageProvider {
    @And("I add customer successfully with firstName, lastName and postCode as (.*) (.*) (.*)$")
    public void addCustomerCommon(String firstName, String lastName, String postCode) throws InterruptedException {
        Thread.sleep(2000);
        getDeleteCustomerPage().setUserInformationDelete(firstName, lastName, postCode);
        getDeleteCustomerPage().clickSubmitDelete();
    }

    @And("^I verify add recent account successfully$")
    public void addCustomerSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        getDeleteCustomerPage().verifyAddCustomerSuccessfullyDelete();
    }

    @When("^I click Customers tab$")
    public void clickCustomerTab() throws InterruptedException {
        getDeleteCustomerPage().clickCustomersTabButton();
    }

    @Then("^I delete customer successfully with firstName as (.*), lastName as (.*) and postCode as (.*)$")
    public void deleteCustomerAccount(String firstName, String lastName, String postCode) throws InterruptedException {
        Thread.sleep(2000);
        getDeleteCustomerPage().deleteCustomer(firstName, lastName, postCode);
    }

    @And("^I verify delete customer with firstName as (.*), lastName as (.*) and postCode as (.*) successfully$")
    public void deleteCustomerSuccessfully(String firstName, String lastName, String postCode) throws InterruptedException {
        Thread.sleep(2000);
        getDeleteCustomerPage().verifyDeleteCustomerSuccessfully(firstName, lastName, postCode, true);
    }
}
