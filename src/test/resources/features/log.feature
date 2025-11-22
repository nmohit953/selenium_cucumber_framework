Feature: Login to SauceDemo1
  Scenario: Successful login with valid credentials
    Given user is on the SauceDemo login page1
    When user logs in with valid credentials1
    Then user should be redirected to the products page1
