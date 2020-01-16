package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static tests.PageProvider.getCommonPage;
public class CustomerLoginPage {

    @FindBy(id = "userSelect")
    WebElement userSelect;

    @FindBy(css = "button.btn:nth-child(2)")
    WebElement loginButton;

    @FindBy(css = ".fontBig")
    WebElement nameLogin;

    public void choseCustomerName(String customerNameSelected) throws InterruptedException {
        Thread.sleep(2000);
        Select userSelects = new Select(userSelect);
        userSelects.selectByVisibleText(customerNameSelected);
    }

    public void clickLoginButton() throws InterruptedException {
        getCommonPage().clickXpath(loginButton);
    }

    public void verifyLoginSuccessfully(String customerNameSelected) throws InterruptedException {
        Thread.sleep(2000);
        String customerName = nameLogin.getText();
        Assert.assertEquals(customerName, customerNameSelected);
    }
}

