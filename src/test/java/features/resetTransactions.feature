Feature: Reset transaction page

    Background:
        Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/customer

    Scenario Outline:  Reset transaction page successfully
        And I login successfully to reset with username as <fullName>
        And I sent the deposit withdrawn reset amount of <depositNumber>
        When I click the withdrawn button reset
        When I withdrawn amount reset of <moneyOut>
        Then I click button to withdrawn reset
        And I verify withdrawn successfully to reset with money of <moneyOutVerify>
        And I click reset button
        Then I verify reset transaction successfully
        Examples:
            | fullName     | depositNumber | moneyOut | moneyOutVerify |
            | Harry Potter | 10000         | 2000     | 2000           |