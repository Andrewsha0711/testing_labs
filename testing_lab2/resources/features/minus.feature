@calculator
Feature: Minus
  As a math idiot
  I want to be told the subtract of two numbers
  So that I can avoid silly mistakes

  @positive @sprint2
  Scenario: Subtract two numbers
    Given I have entered first number 15.0 into the calculator
    And I press minus
    When I have entered second number 3.0 into the calculator
    Then the result should be 12.0 on the screen
