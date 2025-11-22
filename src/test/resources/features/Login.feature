Feature: Login to SauceDemo
  Scenario: Successful login with valid credentials
    Given user is on the SauceDemo login page
    When user logs in with valid credentials
    Then user should be redirected to the products page
