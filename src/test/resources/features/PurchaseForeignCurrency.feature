Feature: PurchaseForeignCurrency
  Background:
    Given The user is logged with valid credentials
    When The user should be able to click Pay Bills



  Scenario: Available currencies

    Given the user accesses the Purchase foreign currency cashtab

    Then following currenciesshould be available

|Australia (dollar)|
|Canada (dollar)|
|Switzerland (franc)|
|China (yuan)|
|Denmark (krone)|
|Eurozone (euro)|
|Great Britain (pound)|
|Japan (yen)|
|Mexico (peso)|
|Norway (krone)|
|New Zealand (dollar)|
|Singapore (dollar)|
  @money

  Scenario: Error messagefor not selecting currency
    Given the user accesses the Purchase foreign currency cashtab
    When usertries to calculate cost without selecting a currency
    Then error message should be displayed
  @money
  Scenario: Error messagefor not entering value
    Given the user accesses the Purchase foreign currency cashtab
    When usertries to calculate cost without entering a value
  Then error message should be displayed