Feature: Search customer to the system

    Background:
        Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/manager/list

    Scenario Outline: Search customer successfully
        And I type <word> to search
        Then I verify search <searchWord> information showing successfully

        Examples:
            | word | searchWord |
            | ne   | ne         |