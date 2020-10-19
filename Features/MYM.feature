Feature: Basic verification before successful login
  Scenario: To verify Login
    Given Application is opened
    Then Accept the message
    When Click on Modifier
    Then User should be Moved to Country-Language Screen
    When select United Kingdom (English)
    And click on OK button
    Then Language should be changed to United Kingdom (English)
    And Modifier should by changed with Modify
    When click on SIGN IN button
    Then User should be moved to Sign IN Account screen
    And Sign In button should be disabled
    When Enter Invalid username
    And Enter Invalid password
    Then Sign In button should be enabled
    And Inline error message should appear
