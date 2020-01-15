Feature: Add customer to the system

    Background:
        Given Open website https://www.way2automation.com/angularjs-protractor/banking/#/manager/addCust

    Scenario Outline: Add customer successfully
        When I type firstName as <firstName> and lastName as <lastName> and postCode as <postCode>
        And I click submit
        Then I verify that system is already added customer as <fullName> successfully
        Examples:
            | firstName | lastName | postCode | fullName |
            | Ha        | Hoa      | 55000    | Ha Hoa   |
            | Ha        | Thu      | 55000    | Ha Thu   |

    Scenario Outline: Add customer unsuccessfully
        When I type firstName as <firstName> and lastName as <lastName> and postCode as <postCode>
        And I click submit
        Then I verify that system is already added customer as <fullName> unsuccessfully
        Examples:
            | firstName | lastName | postCode | fullName |
            | null      | Ham      | 55000    | Ham      |
            | Ha        | null     | 55000    | Ha       |
            | Ha        | Ham      | null     | Ha Ham   |
            | null      | null     | null     | null     |