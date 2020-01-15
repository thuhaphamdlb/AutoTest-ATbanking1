Feature: Open website XYZ bank

    Scenario Outline: Open website XYZ bank
        Given Open website <website>
        Then I verify open website successfully

        Examples:
            | website                                                             |
            | https://www.way2automation.com/angularjs-protractor/banking/#/login |