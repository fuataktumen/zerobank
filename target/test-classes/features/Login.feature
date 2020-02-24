
@All
Feature: Authorized user should be Login Non Authorized user should not Login
@AuthorizedUser
  Scenario: Authorized user should be Login
    Given The user should be Login Page
    When The user should be valid credentials
    Then The user should be able to  login
    And Account summary page should be displayed.

  @invalidCredentials

  Scenario: Non Authorized user should not login with invalid credentials
    Given The user should be Login Page
    When The user should enter invalid credentials
    Then Error message should be "Login and/or password are wrong."

  @BlankCredentials

  Scenario: The user should not login with blank credentials
    Given The user should be Login Page
    When The user should enter submit without typing credentials
    Then Error message should be "Login and/or password are wrong."





