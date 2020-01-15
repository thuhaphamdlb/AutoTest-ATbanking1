Feature: Search customer to the system

    Background:
        Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/login

    Scenario Outline: Search customer successfully
        When I redirect to customer page
        And I type <word> to search
        Then I verify search <searchWord> information showing successfully

        Examples:
            | word | searchWord |
            | Ha   | Ha         |