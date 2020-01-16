package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import runner.TestRunner;

import java.util.List;

public class OpenAccountPage {
    @FindBy(xpath = "//div[1]/div[2]/button")
    WebElement bankManagerLoginButton;

    @FindBy(xpath = "//div[2]/div/div[1]/button[2]")
    WebElement openAccountButton;

    @FindBy(id = "userSelect")
    WebElement userSelect;

    @FindBy(id = "currency")
    WebElement currency;

    @FindBy(xpath = "//div[2]/div/div/form/button")
    WebElement processBtn;

    public void redirectToOpenAccountPage() throws InterruptedException {
        bankManagerLoginButton.click();
        Thread.sleep(1000);
        openAccountButton.click();
    }

    public void getUserInformation(String usernameInput) {
        Select userSelects = new Select(userSelect);
        userSelects.selectByVisibleText(usernameInput);
    }

    public void getCurrency(String currencyInput) {
        Select userSelects = new Select(currency);
        userSelects.selectByVisibleText(currencyInput);
    }

    public void clickProcess() {
        processBtn.click();
    }

    public void verifyUserAlreadyOpen() {
        String successText = "";
        Alert alert = TestRunner.driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();
        for (int i = 0; i < alertMessage.length() - 6; i++) {
            successText += alertMessage.charAt(i);
        }
        Assert.assertEquals(successText, "Account created successfully with account Number");
    }
    public void verifyUserNotOpen(){
        Assert.assertEquals("","");

    }
}