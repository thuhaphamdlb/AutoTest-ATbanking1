Feature: Open account

    Background:
        Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/login

    Scenario Outline:  Open account successfully
        And I redirect to open account page
        When I choose account as <fullName> and currency as <currency>
        And I click open account
        Then I verify that user is already open
        Examples:
            | fullName     | currency |
            | Harry Potter | Pound    |