package pages;

import runner.TestRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonPage {
    public void closeAlertPopup() {
        TestRunner.driver.switchTo().alert().accept();
    }
}
