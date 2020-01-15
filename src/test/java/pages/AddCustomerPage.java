package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import runner.TestRunner;

import java.util.List;

public class AddCustomerPage {
    @FindBy(css = "div.center:nth-child(3) > button:nth-child(1)")
    WebElement bankManagerLoginButton;

    @FindBy(css = "button.btn-lg:nth-child(1)")
    WebElement addCustomerButton;

    @FindBy(xpath = "//div[1]/input")
    WebElement firstName;

    @FindBy(xpath = "//div[2]/input")
    WebElement lastName;

    @FindBy(xpath = "//div[3]/input")
    WebElement postCode;

    @FindBy(xpath = "//form/button")
    WebElement addCustomerBtn;

    @FindBy(id = "userSelect")
    WebElement userSelect;

    @FindBy(xpath = "//*[@id=\"userSelect\"]")
    WebElement accountUser;

    @FindBy(xpath = "//div[2]/div/div[1]/button[2]")
    WebElement openAccountTab;

    public void redirectToAddCustomerPage() throws InterruptedException {
        Thread.sleep(3000);
        bankManagerLoginButton.click();
        Thread.sleep(3000);
        addCustomerButton.click();
    }

    public void setUserInformation(String firstNameInput, String lastNameInput, String postCodeInput) throws InterruptedException {
        this.firstName.clear();
        if (!firstNameInput.equals("null")) {
            Thread.sleep(1000);
            this.firstName.sendKeys(firstNameInput);
        }
        this.lastName.clear();
        if (!lastNameInput.equals("null")) {
            Thread.sleep(1000);
            this.lastName.sendKeys(lastNameInput);
        }
        this.postCode.clear();
        if (!postCodeInput.equals("null")) {
            Thread.sleep(1000);
            this.postCode.sendKeys(postCodeInput);
        }
    }

    public void clickSubmit() {
        addCustomerBtn.click();
    }

    public void verifyAddCustomerSuccessfully() throws InterruptedException {
        String successText = "";
        Alert alert = TestRunner.driver.switchTo().alert();
        String alertMessage = alert.getText();
        Thread.sleep(2000);
        alert.accept();
        for (int i = 0; i < alertMessage.length() - 6; i++) {
            successText += alertMessage.charAt(i);
        }
        Assert.assertEquals(successText, "Customer added successfully with customer");
    }

    public void clickOpenAccountTab() {
        openAccountTab.click();
    }

    public void checkUserInformation(String fullNameInput, Boolean success) {
        accountUser.click();
        List<WebElement> userList = userSelect.findElements(By.tagName("option"));
        Boolean check = false;
        for (WebElement user : userList) {
            if (user.getText().equals(fullNameInput)) {
                check = true;
            }
        }
        if (success) {
            if (!check) Assert.assertEquals(1, 0);
        } else {
            if (check) Assert.assertEquals(1, 0);
        }
    }
}
