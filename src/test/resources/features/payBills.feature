Feature: Pay Bills
  @titleOfPayBills
  Scenario:Title Of Pay Bills
    Given The user is logged with valid credentials
    When The user should be able to  login
    Then The user should be able to click Pay Bills
    And Verify that The Title "Zero - Pay Bills"

  @PayOperation
  Scenario:successful Pay operation
    Given The user is logged with valid credentials
    When The user should be able to  login
    Then The user should be able to click Pay Bills
    And The user completes a successful Pay operation
    And The user should be the message "The payment was successfully submitted."

  @PayOperationWithoutDateAmount
  Scenario:Without Date and Amount Pay Operation
    Given The user is logged with valid credentials
    When The user should be able to  login
    Then The user should be able to click Pay Bills
    And The user completes  blank fields without date and amount
    And The user should be the message "Please fill out this field!"

@AlphabeticalCharacter
  Scenario: Date and Amount Pay Operation accept Number
    Given The user is logged with valid credentials
    When The user should be able to  login
    Then The user should be able to click Pay Bills
    And Amount field should not accept alphabetical or special characters 234
    And Date field should not accept alphabetical characters 231213

