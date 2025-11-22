Feature: Login to SauceDemo
  Scenario Outline: Successful login with valid & invalid credentials
    Given user is on the SauceDemo login page
    When user enters "<Username>" and "<Password>"
    Then login should "<Result>"
  Examples:
| Username |Password | Result  |
|standard_user|secret_sauce| Success|
|locked_out_user|secret_sauce| Failure|
|problem_user|secret_sauce| Success|
|performance_glitch_user|secret_sauce| Success|
|error_user|secret_sauce| Success|
|visual_user|secret_sauce| Success|
||| Failure|