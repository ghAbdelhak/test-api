Feature: Test Calculator
  Scenario: Add two numbers
    Given I have A calculator
    When I add 4 and 6
    Then The result should be 10