package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SearchCustomerPage {
    @FindBy(css = "div.center:nth-child(3) > button:nth-child(1)")
    WebElement bankManagerLoginButton;

    @FindBy(css = "button.btn-lg:nth-child(3)")
    WebElement customerButton;

    @FindBy(xpath = "//div[2]/div/div/table")
    WebElement customerTable;

    @FindBy(css = ".form-control")
    WebElement searchBox;


    public void redirectToCustomerManagementPage() throws InterruptedException {
        bankManagerLoginButton.click();
        Thread.sleep(2000);
        customerButton.click();
    }

    public void typeWordToSearch(String word) {
        searchBox.sendKeys(word);
    }

    public void verifySearchSuccessfully(String searchWord, Boolean success) {
        Boolean check = false;
        List<WebElement> rows = customerTable.findElements(By.tagName("tr"));
        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            if (cols.get(0).getText().equals(searchWord) || cols.get(1).getText().equals(searchWord)
                    || cols.get(2).getText().equals(searchWord)) {
                check = true;
            }
        }
        if (success) {
            if (!check == false) Assert.assertEquals(1, 0);
        } else {
            if (check == false) Assert.assertEquals(1, 0);
        }
    }
}
