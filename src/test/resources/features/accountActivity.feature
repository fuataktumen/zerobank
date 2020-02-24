Feature: Account Activity
  @titleOfAccountActivity
  Scenario:Title Of Account Activity
    Given The user is logged with valid credentials
    When The user should be able to  login
    Then The user should be able to click accountActivity
    And Verify that The Title "Zero - Account Activity"

@AccountFirstSelectOptions

Scenario: Default Option
  Given The user is logged with valid credentials
  When The user should be able to  login
  Then The user should be able to click accountActivity
  And Verify that in the Account drop down default option should be Savings

@AccountSelectOptions
  Scenario:Select Options
  Given The user is logged with valid credentials
  When The user should be able to  login
  Then The user should be able to click accountActivity
  And Account drop down should have the following options:

|Savings| Checking|Loan|Credit Card| Brokerage|


  @tableColumns
  Scenario:Select Options
    Given The user is logged with valid credentials
    When The user should be able to  login
    Then The user should be able to click accountActivity
    And Transactions table should have column names
  |Date| Description| Deposit| Withdrawal|

