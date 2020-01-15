package pages;

import cucumber.api.java.cs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static tests.PageProvider.getCommonPage;

public class CustomerDepositPage {
    private WebDriver driver;

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

    @FindBy(xpath = "//div[3]/button[1]")
    WebElement transactionButton;

    @FindBy(xpath = "//div[2]/table")
    WebElement transactionTable;

    String dateTimeDeposit;

    public String getDateTimeDeposit() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMM dd, yyyy h:mm:ss a");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    public void choseCustomerNameDeposit(String customerNameSelected) throws InterruptedException {
        Thread.sleep(3000);
        Select userSelects = new Select(userSelect);
        userSelects.selectByVisibleText(customerNameSelected);
    }

    public void clickLoginButtonDeposit() {
        loginButton.click();
    }

    public void verifyLoginDepositSuccessfully(String customerNameSelected) throws InterruptedException {
        Thread.sleep(2000);
        String customerName = nameLogin.getText();
        Assert.assertEquals(customerName, customerNameSelected);
    }

    public void clickDepositButtonTop() {
        depositButtonTop.click();
    }

    public void sendDepositNumber(String depositNumber) {
        depositInput.sendKeys(depositNumber);
    }

    public void submitDeposit() {
        depositSubmitButton.click();
        dateTimeDeposit = getDateTimeDeposit();
    }

    public void verifyDepositSuccessfully() {
        String successText = spanDepositSession.getText();
        Assert.assertEquals(successText, "Deposit Successful");
    }

    public void redirectToTransactionsPage() {
        transactionButton.click();
    }

    public void verifyDepositTransactionsSuccessfully(String moneyDeposited) throws InterruptedException {
        Thread.sleep(2000);
        boolean check = false;
        List<WebElement> rows = transactionTable.findElements(By.tagName("tr"));
        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            if (cols.get(0).getText().equals(dateTimeDeposit) && cols.get(1).getText().equals(moneyDeposited)
                    && cols.get(2).getText().equals("Credit")) {
                check = true;
            }
        }
        Assert.assertEquals(check, true);
    }

    public void verifyDepositUnsuccessfully() {

    }
}
