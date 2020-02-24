Feature: Account Summary

@VerifyTitle
  Scenario: Title of Account Summary
    Given The user should be Login Page
    When The user should be valid credentials
    Then The user should be able to  login
    And Verify that The Title "Zero – Account Summary"

@TitleOfUnderAccountSummary

Scenario: Titles under the Account Summary
  Given The user should be Login Page
  When  The user should be valid credentials
  Then The user should be able to  login
  And Verify that Account summary page should have to following account types:
|Cash Accounts| Investment Accounts| Credit Accounts| Loan Accounts|


  @TitleOfUnderCreditAccount

  Scenario: Titles under the Account Summary
    Given The user should be Login Page
    When  The user should be valid credentials
    Then The user should be able to  login
    And Verify that Credit Accountstable must have Account, Credit Card and Balance


      | Account| Credit Card| Balance |





