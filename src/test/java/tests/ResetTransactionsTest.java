package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.text.ParseException;

public class ResetTransactionsTest extends PageProvider{
    @And("I login successfully to reset with username as (.*)$")
    public void userLogin(String username) throws InterruptedException {
        Thread.sleep(3000);
        getResetTransactionsPage().choseCustomerNameReset(username);
        getResetTransactionsPage().clickLoginButtonReset();
        Thread.sleep(3000);
        getResetTransactionsPage().verifyLoginResetSuccessfully(username);
    }

    @And("I sent the deposit withdrawn reset amount of (.*)$")
    public void sendDeposit(String numberDeposit) throws InterruptedException {
        getResetTransactionsPage().clickDepositButtonTopReset();
        Thread.sleep(3000);
        getResetTransactionsPage().sendDepositNumberReset(numberDeposit);
        Thread.sleep(3000);
        getResetTransactionsPage().submitDepositWithdrawnReset();
        Thread.sleep(3000);
        getResetTransactionsPage().verifyDepositSuccessfullyReset();
    }

    @When("^I click the withdrawn button reset$")
    public void clickWithdrawnButton() throws InterruptedException {
        getResetTransactionsPage().clickWithdrawnButtonReset();
    }

    @When("^I withdrawn amount reset of (.*)$")
    public void withdrawnMoney(String numberWithdrawn) throws InterruptedException {
        Thread.sleep(3000);
        getResetTransactionsPage().withdrawnMoneyReset(numberWithdrawn);
    }

    @Then("^I click button to withdrawn reset$")
    public void clickSubmitToWithdrawn() throws InterruptedException {
        getResetTransactionsPage().clickWithdrawnSubmitReset();
    }

    @And("^I verify withdrawn successfully to reset with money of (.*)$")
    public void verifyWithdrawnSuccessfully(String moneyWithdrawn) throws InterruptedException, ParseException {
        Thread.sleep(3000);
        getResetTransactionsPage().verifyWithdrawnSuccessfullyReset(moneyWithdrawn);
        Thread.sleep(4000);
        getResetTransactionsPage().verifyWithdrawnTransactionsSuccessfullyReset(moneyWithdrawn);
    }

    @Then("^I click reset button$")
    public void clickResetButton() throws InterruptedException {
        getResetTransactionsPage().clickResetButton();
    }
    @Then("^I verify reset transaction successfully$")
    public void verifyResetTransactionSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        getResetTransactionsPage().verifyResetTransactionSuccessfully();
    }
}
