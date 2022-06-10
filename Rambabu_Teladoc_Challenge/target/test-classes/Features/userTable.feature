Feature: Test user table functionality

  Scenario: Create user to user table
    Given user open way2automation on browser
    When user click Add user button
    And enter first name and last name and username and cell phone
    And select role and click save button
    Then user added to the user records table
  
  Scenario: Delete user from user table
  Given user open way2automation on browser
  When delete the user from table
  Then user record deleted from user table
  
