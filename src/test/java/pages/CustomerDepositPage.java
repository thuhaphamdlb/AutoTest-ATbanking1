package pages;

import cucumber.api.java.cs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    public String formartDate(String dateTime) throws ParseException {
        String userDateFormat = "MMM dd, yyyy h:mm";
        DateFormat sdf = new SimpleDateFormat(userDateFormat);
        Date date = sdf.parse(dateTime);
        return sdf.format(date);
    }

    public String getDateTimeDeposit() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MMM dd, yyyy h:mm");
        return myDateObj.format(myFormatObj);
    }

    public void choseCustomerNameDeposit(String customerNameSelected) throws InterruptedException {
        Thread.sleep(3000);
        Select userSelects = new Select(userSelect);
        userSelects.selectByVisibleText(customerNameSelected);
    }

    public void clickLoginButtonDeposit() throws InterruptedException {
        getCommonPage().clickXpath(loginButton);
    }

    public void verifyLoginDepositSuccessfully(String customerNameSelected) throws InterruptedException {
        Thread.sleep(2000);
        String customerName = nameLogin.getText();
        Assert.assertEquals(customerName, customerNameSelected);
    }

    public void clickDepositButtonTop() throws InterruptedException {
        getCommonPage().clickXpath(depositButtonTop);
    }

    public void sendDepositNumber(String depositNumber) {
        depositInput.sendKeys(depositNumber);
    }

    public void submitDeposit() throws InterruptedException {
        getCommonPage().clickXpath(depositSubmitButton);
        dateTimeDeposit = getDateTimeDeposit();
    }

    public void verifyDepositSuccessfully() {
        String successText = spanDepositSession.getText();
        Assert.assertEquals(successText, "Deposit Successful");
    }

    public void redirectToTransactionsPage() throws InterruptedException {
        getCommonPage().clickXpath(transactionButton);
    }

    public void verifyDepositTransactionsSuccessfully(String moneyDeposited) throws InterruptedException, ParseException {
        Thread.sleep(2000);
        boolean check = false;
        List<WebElement> rows = transactionTable.findElements(By.tagName("tr"));
        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            if (formartDate(cols.get(0).getText()).equals(dateTimeDeposit) && cols.get(1).getText().equals(moneyDeposited)
                    && cols.get(2).getText().equals("Credit")) {
                check = true;
                break;
            }
        }
        Assert.assertEquals(check, true);
    }

    public void verifyDepositUnsuccessfully(String moneyDeposited) throws InterruptedException, ParseException {
        Thread.sleep(2000);
        boolean check = false;
        List<WebElement> rows = transactionTable.findElements(By.tagName("tr"));
        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            if (formartDate(cols.get(0).getText()).equals(dateTimeDeposit) && cols.get(1).getText().equals(moneyDeposited)
                    && cols.get(2).getText().equals("Credit")) {
                check = true;
                break;
            }
        }
        Assert.assertEquals(check, false);
    }
}
