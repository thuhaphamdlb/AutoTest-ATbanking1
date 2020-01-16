package tests;

import org.openqa.selenium.support.PageFactory;
import pages.*;
import runner.TestRunner;

public class PageProvider {

    private static OpenWebsitePage openWebsitePage;
    private static CustomerLoginPage customerLoginPage;
    private static CustomerDepositPage customerDepositPage;
    private static AddCustomerPage addCustomerPage;
    private static OpenAccountPage openAccountPage;
    private static CommonPage commonPage;
    private static CustomerWithDrawnPage customerWithDrawnPage;
    private static DeleteCustomerPage deleteCustomerPage;
    private static SearchCustomerPage searchCustomerPage;
    private static ResetTransactionsPage resetTransactionsPage;

    public static OpenAccountPage getOpenAccountPage() {
        if (openAccountPage == null) {
            openAccountPage = PageFactory.initElements(TestRunner.driver, OpenAccountPage.class);
        }
        return openAccountPage;
    }


    public static CommonPage getCommonPage() {
        if (commonPage == null) {
            commonPage = PageFactory.initElements(TestRunner.driver, CommonPage.class);
        }
        return commonPage;
    }

    public static OpenWebsitePage getOpenWebsitePage() {
        if (openWebsitePage == null) {
            openWebsitePage = PageFactory.initElements(TestRunner.driver, OpenWebsitePage.class);
        }
        return openWebsitePage;
    }

    public static AddCustomerPage getAddCustomerPage() {
        if (addCustomerPage == null) {
            addCustomerPage = PageFactory.initElements(TestRunner.driver, AddCustomerPage.class);
        }
        return addCustomerPage;
    }

    public static CustomerLoginPage getCustomerLoginPage() {
        if (customerLoginPage == null) {
            customerLoginPage = PageFactory.initElements(TestRunner.driver, CustomerLoginPage.class);
        }
        return customerLoginPage;
    }

    public static CustomerDepositPage getCustomerDepositPage() {
        if (customerDepositPage == null) {
            customerDepositPage = PageFactory.initElements(TestRunner.driver, CustomerDepositPage.class);
        }
        return customerDepositPage;
    }

    public static CustomerWithDrawnPage getCustomerWithDrawnPage() {
        if (customerWithDrawnPage == null) {
            customerWithDrawnPage = PageFactory.initElements(TestRunner.driver, CustomerWithDrawnPage.class);
        }
        return customerWithDrawnPage;
    }

    public static DeleteCustomerPage getDeleteCustomerPage() {
        if (deleteCustomerPage == null) {
            deleteCustomerPage = PageFactory.initElements(TestRunner.driver, DeleteCustomerPage.class);
        }
        return deleteCustomerPage;
    }

    public static SearchCustomerPage getSearchCustomerPage() {
        if (searchCustomerPage == null) {
            searchCustomerPage = PageFactory.initElements(TestRunner.driver, SearchCustomerPage.class);
        }
        return searchCustomerPage;
    }
    public static ResetTransactionsPage getResetTransactionsPage() {
        if (resetTransactionsPage == null) {
            resetTransactionsPage = PageFactory.initElements(TestRunner.driver, ResetTransactionsPage.class);
        }
        return resetTransactionsPage;
    }
}