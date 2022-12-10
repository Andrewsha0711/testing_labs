@calculator
Feature: Divide
  As a math idiot
  I want to be told the division of two numbers
  So that I can avoid silly mistakes

  Scenario: Divide two numbers
    Given I have entered first number 15.0 into the calculator
    And I press divide
    When I have entered second number 3.0 into the calculator
    Then the result should be 5.0 on the screen
