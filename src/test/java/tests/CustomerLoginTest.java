package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerLoginTest extends PageProvider {

    @When("^I click customer name as (.*)$")
    public void choseCustomerName(String customerNameSelected) throws InterruptedException {
        Thread.sleep(2000);
        getCustomerLoginPage().choseCustomerName(customerNameSelected);
    }

    @And("^I click login button$")
    public void clickLoginButton() throws InterruptedException {
        getCustomerLoginPage().clickLoginButton();
    }

    @Then("^I verify login successfully with (.*)$")
    public void verifyLoginSuccessfully(String customerNameEntered) throws InterruptedException {
        Thread.sleep(2000);
        getCustomerLoginPage().verifyLoginSuccessfully(customerNameEntered);
    }
}
