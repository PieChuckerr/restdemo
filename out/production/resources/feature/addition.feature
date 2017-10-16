Feature: Testing a REST API
  Users should be able to add two numbers

  Scenario: number addition service
    When baseUri is /messages/add
    And I set the numbers to 1 and 2
    And I make get request
    Then result should be 3
    And status code should be 200
    And  response data should in application/json

