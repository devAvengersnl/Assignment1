# Created by akshaya at 27-5-19
Feature: As a user I should be able to sign up in the application and can login

  Scenario: User should be able to login in the application

    Given User with valid url
    When User fill all the details
    And Submit the form
    Then User get registered
    And User is  able to see his name  on dashboard
