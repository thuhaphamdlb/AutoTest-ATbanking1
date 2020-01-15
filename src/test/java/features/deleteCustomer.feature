Feature: Delete customer out of the system

    Background:
        Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/manager/addCust
        And I add customer successfully with firstName, lastName and postCode as An An 55000
        And I verify add recent account successfully

    Scenario Outline: Delete customer successfully
        When I click Customers tab
        Then I delete customer successfully with firstName as <firstName>, lastName as <lastName> and postCode as <postCode>
        And I verify delete customer with firstName as <firstNameCheck>, lastName as <lastNameCheck> and postCode as <postCodeCheck> successfully
        Examples:
            | firstName | lastName | postCode | firstNameCheck | lastNameCheck | postCodeCheck |
            | An        | An       | 55000    | An             | An            | 55000         |
