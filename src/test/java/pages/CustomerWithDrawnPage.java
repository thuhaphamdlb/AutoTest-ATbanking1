package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class CustomerWithDrawnPage {

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

    @FindBy(xpath = "//div[3]/button[1]")
    WebElement transactionButton;

    @FindBy(xpath = "//div[2]/table")
    WebElement transactionTable;

    int moneyBeforeWithdrawn, moneyAfterWithdrawn;
    String withdrawnTime;

    public String formartDate(String dateTime) throws ParseException {
        String userDateFormat = "MMM dd, yyyy h:mm";
        DateFormat sdf = new SimpleDateFormat(userDateFormat);
        Date date = sdf.parse(dateTime);
        return sdf.format(date);
    }

    public String getDateTimeWithdrawn() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMM dd, yyyy h:mm");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    public void choseCustomerNameWithDrawn(String customerNameSelected) {
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
        withdrawnTime = getDateTimeWithdrawn();
        moneyAfterWithdrawn = Integer.parseInt(moneyAmount.getText());
    }

    public void verifyWithdrawnSuccessfully(String moneyWithdrawnActual) {
        int moneyWithdrawn = moneyBeforeWithdrawn - moneyAfterWithdrawn;
        Assert.assertEquals(Integer.parseInt(moneyWithdrawnActual), moneyWithdrawn);
    }

    public void verifyWithdrawnTransactionsSuccessfully(String moneyWithdrawnActual) throws ParseException, InterruptedException {
        boolean check = false;
        transactionButton.click();
        Thread.sleep(1000);
        List<WebElement> rows = transactionTable.findElements(By.tagName("tr"));
        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            if (formartDate(cols.get(0).getText()).equals(withdrawnTime) && cols.get(1).getText().equals(moneyWithdrawnActual)
                    && cols.get(2).getText().equals("Debit")) {
                check = true;
                break;
            }
        }
        Assert.assertEquals(check, true);
    }
}
