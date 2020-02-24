Feature: Add new payee under pay bills

  Background:
    Given The user is logged with valid credentials
    When The user should be able to click Pay Bills

@AddNewPayee
  Scenario: Add a new payee
    Given Add New Payeetab
  And creates new payee usingfollowing information

    |Payee Name|The Law Offices of Hyde, Price & Scharks|
    |Payee Address|100 Samest, Anytown, USA, 10001|
    |Account|Checking|
    |Payee details|XYZ account|
Then message The new payee The Law Offices of Hyde, Price & Scharks was successfully created.should be displayed