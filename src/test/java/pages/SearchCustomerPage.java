package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SearchCustomerPage {
    @FindBy(xpath = "//div[2]/div/div/table")
    WebElement customerTable;

    @FindBy(css = ".form-control")
    WebElement searchBox;

    public void typeWordToSearch(String word) {
        searchBox.sendKeys(word);
    }

    public void verifySearchSuccessfully(String searchWord) {
        boolean check = false;
        String keysearch = searchWord.toLowerCase();
        List<WebElement> rows = customerTable.findElements(By.tagName("tr"));
        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            if (cols.get(0).getText().toLowerCase().contains(keysearch)
                    || cols.get(1).getText().toLowerCase().contains(keysearch)
                    || cols.get(2).getText().toLowerCase().contains(keysearch)) {
                check = true;
            }
        }
        Assert.assertEquals(check,true);
    }
}
