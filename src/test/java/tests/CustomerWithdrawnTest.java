package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.text.ParseException;

public class CustomerWithdrawnTest extends PageProvider {

    @And("I login successfully to withdrawn with username as (.*)$")
    public void userLogin(String username) throws InterruptedException {
        Thread.sleep(3000);
        getCustomerWithDrawnPage().choseCustomerNameWithDrawn(username);
        getCustomerWithDrawnPage().clickLoginButtonWithDrawn();
        Thread.sleep(3000);
        getCustomerWithDrawnPage().verifyLoginWithDrawnSuccessfully(username);
    }

    @And("I sent the deposit withdrawn amount of (.*)$")
    public void sendDeposit(String numberDeposit) throws InterruptedException {
        getCustomerWithDrawnPage().clickDepositButtonTopWithdrawn();
        Thread.sleep(3000);
        getCustomerWithDrawnPage().sendDepositNumberWithdrawn(numberDeposit);
        getCustomerWithDrawnPage().submitDepositWithdrawn();
        Thread.sleep(3000);
        getCustomerWithDrawnPage().verifyDepositSuccessfullyWithdrawn();
    }

    @When("^I click the withdrawn button$")
    public void clickWithdrawnButton() throws InterruptedException {
        getCustomerWithDrawnPage().clickWithdrawnButton();
    }

    @When("^I withdrawn amount of (.*)$")
    public void withdrawnMoney(String numberWithdrawn) throws InterruptedException {
        Thread.sleep(3000);
        getCustomerWithDrawnPage().withdrawnMoney(numberWithdrawn);
    }

    @Then("^I click button to withdrawn$")
    public void clickSubmitToWithdrawn() throws InterruptedException {
        getCustomerWithDrawnPage().clickWithdrawnSubmit();
    }

    @And("^I verify withdrawn successfully with money of (.*)$")
    public void verifyWithdrawnSuccessfully(String moneyWithdrawn) throws InterruptedException, ParseException {
        Thread.sleep(3000);
        getCustomerWithDrawnPage().verifyWithdrawnSuccessfully(moneyWithdrawn);
        Thread.sleep(3000);
        getCustomerWithDrawnPage().verifyWithdrawnTransactionsSuccessfully(moneyWithdrawn);
    }
}
