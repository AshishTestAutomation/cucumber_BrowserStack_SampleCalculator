Feature: Basic Calculation in Calculator
  Scenario: Test with basic calculation of two given numbers
    Given Open Calculator
    When adding number 1 and number 2
    Then Result should be sum of the two given numbers
    When Subtracting number 1 and number 2
    Then Result should be deduction of the two given numbers
    When Multiplying number 1 and number 2
    Then Result should be the multiplication of the two given numbers
    When Dividing number 1 and number 2
    Then Result should be the division of the two given numbers