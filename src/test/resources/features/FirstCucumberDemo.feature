
@regression
Feature: Deposit Tests - This is the title

  Here we would write the extra details about the feature
  Here we would write the extra details about the feature
  Here we would write the extra details about the feature


  Scenario: we give scenario name here

    Given Bank account 1 exists with $1000 balance

    When Bank account 1 deposits $100 dollars


    Then Bank account 1 should have $1100 dollars in balance

    @smoke
    Scenario: Money Transfer with enough balance
      Given User with account number 123456 is registered
      When User with account number 123456 transfers $300
      And User with account number 123456 transfers $200
      Then User with account number 123456 should have $0 in balance



