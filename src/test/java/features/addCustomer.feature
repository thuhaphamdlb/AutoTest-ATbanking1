Feature: Add customer to the system

    Background:
        Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/manager/addCust

    Scenario Outline: Add customer successfully with valid information
        When I type firstName as <firstName> and lastName as <lastName> and postCode as <postCode>
        And I click submit
        Then I verify that system is already added customer as <fullName> successfully

        Examples:
            | firstName | lastName | postCode | fullName |
            | Ha        | Hoa      | 55000    | Ha Hoa   |

    Scenario Outline: Add customer unsuccessfully with blank information
        When I type firstName as <firstName> and lastName as <lastName> and postCode as <postCode>
        And I click submit
        Then I verify that system is already added customer as <fullName> unsuccessfully

        Examples:
            | firstName | lastName | postCode | fullName |
            | Ha        | Ham      | null     | Ha Ham   |

    Scenario Outline: Add customer unsuccessfully with existent account
        When I type firstName as <firstName> and lastName as <lastName> and postCode as <postCode>
        And I click submit
        Then I verify that system added duplicate customer as <fullName> unsuccessfully

        Examples:
            | firstName | lastName | postCode | fullName     |
            | Harry     | Potter   | E725JB   | Harry Potter |