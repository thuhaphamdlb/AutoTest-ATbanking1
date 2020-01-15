package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddCustomerTest extends PageProvider {
    @And("^I redirect to add customer page$")
    public void redirectToAddCustomerPage() throws InterruptedException {
        Thread.sleep(2000);
        getAddCustomerPage().redirectToAddCustomerPage();
    }

    @When("^I type firstName as (.+) and lastName as (.+) and postCode as (.+)$")
    public void inputUserInformation(String firstName, String lastName, String postCode) throws InterruptedException {
        Thread.sleep(2000);
        getAddCustomerPage().setUserInformation(firstName, lastName, postCode);
    }

    @And("^I click submit$")
    public void clickSubmit() throws InterruptedException {
        Thread.sleep(2000);
        getAddCustomerPage().clickSubmit();
    }

    @Then("^I verify that system is already added customer as (.+) successfully$")
    public void verifyCustomerAddSuccessfully(String fullName) throws InterruptedException {
        Thread.sleep(2000);
        getCommonPage().closeAlertPopup();
        Thread.sleep(2000);
        getAddCustomerPage().clickOpenAccountTab();
        Thread.sleep(2000);
        getAddCustomerPage().checkUserInformation(fullName, true);
    }

    @Then("^I verify that system is already added customer as (.+) unsuccessfully$")
    public void verifyCustomerAddUnSuccessfully(String fullName) throws InterruptedException {
        Thread.sleep(2000);
        getAddCustomerPage().clickOpenAccountTab();
        Thread.sleep(2000);
        getAddCustomerPage().checkUserInformation(fullName, false);
    }
}
