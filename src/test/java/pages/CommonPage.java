package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import runner.TestRunner;

public class CommonPage {

    public void closeAlertPopup() {
        TestRunner.driver.switchTo().alert().accept();
    }

    public void clickXpath(WebElement xpath) throws InterruptedException {
        boolean check = false;
        while (check == false) {
            try {
                xpath.click();
                check = true;
                break;
            } catch (Exception e) {
                Thread.sleep(1000);
            }
        }
    }
}
