@regression
Feature: Transfer

  #one of the main principles of writing cucumber feature files
  #steps have to be as dynamic as possible to promote the step resuability within other scenario as
  #well
  Scenario: Money transfer with insufficient funds
    Given User with account number 2343245 is registered
    And User with account number 4210 deposited $1000.00
    When User with account number 4210 transfers $1100.00
    Then User with account number 4210 should have $1000.00 in balance
    And User should see Insufficient Funds message

    #when the step is not highlighted it means it already has an implementation(step def)
@smoke
  Scenario: Money transfer with sufficient funds
    Given User with account number 12334563 is registered

    @IGNORE
    Scenario: Demo String params
      Given User is on "qa4-chase.com"