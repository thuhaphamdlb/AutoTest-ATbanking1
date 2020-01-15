Feature: Customer deposit

    Background:
        Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/login
        And I login successfully with username as Harry Potter

    Scenario Outline: Customer deposit successfully
        When I click deposit button top to deposit
        Then I send the <number> to deposit
        Then I submit the deposit
        Then I verify deposit successfully
        Then I redirect to transactions page
        Then I verify deposit transactions successfully with money of <moneyDeposited>

        Examples:
            | number | moneyDeposited |
            | 2000   | 2000           |
            | 10000  | 10000          |
            | 1200   | 1200           |

    Scenario Outline: Customer deposit unsuccessfully
        When I click deposit button top to deposit
        Then I send the <number> to deposit
        Then I submit the deposit
        Then I verify deposit unsuccessfully

        Examples:
            | number |
            |        |
            | e      |