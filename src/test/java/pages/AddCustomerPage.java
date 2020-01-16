package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import runner.TestRunner;

import java.util.List;
import static tests.PageProvider.getCommonPage;

public class AddCustomerPage {

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

    public void clickSubmit() throws InterruptedException {
        getCommonPage().clickXpath(addCustomerBtn);
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
    public void verifyAddCustomerUnSuccessfully() throws InterruptedException {
        String unSuccessText = "";
        Alert alert = TestRunner.driver.switchTo().alert();
        String alertMessage = alert.getText();
        Thread.sleep(1000);
        alert.accept();
        for (int i = 0; i < alertMessage.length(); i++) {
            unSuccessText += alertMessage.charAt(i);
        }
        Assert.assertEquals(unSuccessText, "Please check the details. Customer may be duplicate.");
    }

    public void clickOpenAccountTab() throws InterruptedException {
        getCommonPage().clickXpath(openAccountTab);
    }

    public void checkUserInformation(String fullNameInput, Boolean success) throws InterruptedException {
        getCommonPage().clickXpath(accountUser);
        List<WebElement> userList = userSelect.findElements(By.tagName("option"));
        boolean check = false;
        for (WebElement user : userList) {
            if (user.getText().equals(fullNameInput)) {
                check = true;
            }
        }
        if (success) {
            Assert.assertEquals(check, true);
        } else {
            Assert.assertEquals(check, false);
        }
    }

    public void addCustomerUnsuccessfully(){
        Assert.assertEquals("","Please check the details. Customer may be duplicate.");
    }
}
