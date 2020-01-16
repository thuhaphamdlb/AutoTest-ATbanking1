Feature: Withdrawn

    Background:
        Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/customer
        And I login successfully to withdrawn with username as Harry Potter
        And I sent the deposit withdrawn amount of 10000

    Scenario Outline: Withdrawn
        When I click the withdrawn button
        And I withdrawn amount of <numberWithdrawn>
        Then I click button to withdrawn
        And I verify withdrawn successfully with money of <moneyOut>
        Examples:
            | numberWithdrawn | moneyOut |
            | 2000            | 2000     |