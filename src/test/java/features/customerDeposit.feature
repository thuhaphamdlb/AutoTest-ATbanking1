Feature: Customer deposit

    Background:
        Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/customer
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
            | 10000  | 10000          |

    Scenario Outline: Customer deposit unsuccessfully with blank deposit field
        When I click deposit button top to deposit
        Then I send the <number> to deposit
        Then I submit the deposit
        Then I redirect to transactions page
        Then I verify deposit unsuccessfully with amount of <moneyDeposited>

        Examples:
            | number | moneyDeposited |
            |        |                |

    Scenario Outline: Customer deposit unsuccessfully with string deposit field
        When I click deposit button top to deposit
        Then I send the <number> to deposit
        Then I submit the deposit
        Then I redirect to transactions page
        Then I verify deposit unsuccessfully with amount of <moneyDeposited>

        Examples:
            | number | moneyDeposited |
            | e      | e              |

    Scenario Outline: Customer deposit unsuccessfully with negative deposit field
        When I click deposit button top to deposit
        Then I send the <number> to deposit
        Then I submit the deposit
        Then I redirect to transactions page
        Then I verify deposit unsuccessfully with amount of <moneyDeposited>

        Examples:
            | number | moneyDeposited |
            | -5     | -5             |