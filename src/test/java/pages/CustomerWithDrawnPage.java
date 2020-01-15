package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomerWithDrawnPage {
    @FindBy(xpath = "//div[3]/div/div[2]/div/div[1]/div[1]/button")
    WebElement customerLoginButton;

    @FindBy(id = "userSelect")
    WebElement userSelect;

    @FindBy(xpath = "//div/form/button")
    WebElement loginButton;

    @FindBy(xpath = "//div/div[1]/strong/span")
    WebElement nameLogin;

    @FindBy(xpath = "//div[3]/button[2]")
    WebElement depositButtonTop;

    @FindBy(xpath = "//div[4]/div/form/div/input")
    WebElement depositInput;

    @FindBy(xpath = "//div[4]/div/form/button")
    WebElement depositSubmitButton;

    @FindBy(xpath = "//div[4]/div/span")
    WebElement spanDepositSession;

    @FindBy(xpath = "//button[3]")
    WebElement withdrawnButton;

    @FindBy(xpath = "//div[4]/div/form/div/input")
    WebElement getWithdrawnText;

    @FindBy(xpath = "//form/button")
    WebElement withdrawnSubmit;

    @FindBy(xpath = "//strong[2]")
    WebElement moneyAmount;

    int moneyBeforeWithdrawn, moneyAfterWithdrawn;

    public void clickCustomerLoginButtonWithDrawn() {
        customerLoginButton.click();
    }

    public String getDateTimeWithdrawn() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMM dd, yyyy h:mm");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    public void choseCustomerNameWithDrawn(String customerNameSelected) throws InterruptedException {
        Thread.sleep(2000);
        Select userSelects = new Select(userSelect);
        userSelects.selectByVisibleText(customerNameSelected);
    }

    public void clickLoginButtonWithDrawn() {
        loginButton.click();
    }

    public void verifyLoginWithDrawnSuccessfully(String customerNameSelected) {
        String customerName = nameLogin.getText();
        Assert.assertEquals(customerName, customerNameSelected);
    }

    public void clickDepositButtonTopWithdrawn() {
        depositButtonTop.click();
    }

    public void sendDepositNumberWithdrawn(String depositNumber) {
        depositInput.sendKeys(depositNumber);
    }

    public void submitDepositWithdrawn() {
        depositSubmitButton.click();
    }

    public void verifyDepositSuccessfullyWithdrawn() {
        String successText = spanDepositSession.getText();
        Assert.assertEquals(successText, "Deposit Successful");
    }

    public void clickWithdrawnButton() {
        moneyBeforeWithdrawn = Integer.parseInt(moneyAmount.getText());
        withdrawnButton.click();
    }

    public void withdrawnMoney(String numberWithdrawn) {
        getWithdrawnText.sendKeys(numberWithdrawn);
    }

    public void clickWithdrawnSubmit() {
        withdrawnSubmit.click();
        moneyAfterWithdrawn = Integer.parseInt(moneyAmount.getText());
    }

    public void verifyWithdrawnSuccessfully(String moneyWithdrawnActual) {
        int moneyWithdrawn = moneyBeforeWithdrawn - moneyAfterWithdrawn;
        Assert.assertEquals(Integer.parseInt(moneyWithdrawnActual), moneyWithdrawn);
    }
    public void verifyWithdrawnTransactionsSuccessfully(String moneyWithdrawnActual) {
        String date = getDateTimeWithdrawn();
        int moneyWithdrawn = moneyBeforeWithdrawn - moneyAfterWithdrawn;
        Assert.assertEquals(Integer.parseInt(moneyWithdrawnActual), moneyWithdrawn);
    }
}
