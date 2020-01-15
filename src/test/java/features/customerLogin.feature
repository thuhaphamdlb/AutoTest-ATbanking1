Feature: Customer Login

    Background:
        Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/login

    Scenario Outline: Customer login
        And I click customer login button
        When I click customer name as <customerName>
        And I click login button
        Then I verify login successfully with <customerNameEntered>
        Examples:
            | customerName | customerNameEntered |
            | Harry Potter | Harry Potter        |