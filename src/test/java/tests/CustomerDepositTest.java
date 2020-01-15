package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerDepositTest extends PageProvider {

    @And("I login successfully with username as (.*)$")
    public void userLogin(String username) throws InterruptedException {
        Thread.sleep(2000);
        getCustomerDepositPage().clickCustomerLoginButtonDeposit();
        Thread.sleep(2000);
        getCustomerDepositPage().choseCustomerNameDeposit(username);
        Thread.sleep(2000);
        getCustomerDepositPage().clickLoginButtonDeposit();
        Thread.sleep(2000);
        getCustomerDepositPage().verifyLoginDepositSuccessfully(username);
    }

    @When("^I click deposit button top to deposit$")
    public void clickDepositButtonTop() throws InterruptedException {
        Thread.sleep(2000);
        getCustomerDepositPage().clickDepositButtonTop();
    }

    @Then("^I send the (.*) to deposit$")
    public void sendNumber(String depositNumber) throws InterruptedException {
        Thread.sleep(2000);
        getCustomerDepositPage().sendDepositNumber(depositNumber);
    }

    @Then("^I submit the deposit$")
    public void submitDeposit() throws InterruptedException {
        Thread.sleep(2000);
        getCustomerDepositPage().submitDeposit();
    }

    @Then("^I verify deposit successfully$")
    public void verifyDepositSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        getCustomerDepositPage().verifyDepositSuccessfully();
    }

    @Then("^I redirect to transactions page$")
    public void redirectToTransactionsPage() throws InterruptedException {
        Thread.sleep(2000);
        getCustomerDepositPage().redirectToTransactionsPage();
    }

    @Then("^I verify deposit transactions successfully with money of (.*)$")
    public void verifyDepositTransactionsSuccessfully(String moneyDeposit) throws InterruptedException {
        Thread.sleep(2000);
        getCustomerDepositPage().verifyDepositTransactionsSuccessfully(moneyDeposit, true);
    }

    @Then("^I verify deposit unsuccessfully$")
    public void verifyDepositUnsuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        getCustomerDepositPage().verifyDepositUnsuccessfully();
    }

}
