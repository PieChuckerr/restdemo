$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("feature/addition.feature");
formatter.feature({
  "line": 1,
  "name": "Testing a REST API",
  "description": "Users should be able to add two numbers",
  "id": "testing-a-rest-api",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "number addition service",
  "description": "",
  "id": "testing-a-rest-api;number-addition-service",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "baseUri is /messages/add",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I set the numbers to 1 and 2",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I make get request",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "result should be 3",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "status code should be 200",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "response data should in application/json",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "/messages/add",
      "offset": 11
    }
  ],
  "location": "StepDefinition.baseUri(String)"
});
formatter.result({
  "duration": 588851656,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 21
    },
    {
      "val": "2",
      "offset": 27
    }
  ],
  "location": "StepDefinition.header(String,String)"
});
formatter.result({
  "duration": 1593051,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.makeTheRequest()"
});
formatter.result({
  "duration": 25323967,
  "error_message": "java.lang.NullPointerException\r\n\tat com.example.restdemo.web.StepDefinition.makeTheRequest(StepDefinition.java:48)\r\n\tat ✽.And I make get request(feature/addition.feature:7)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 17
    }
  ],
  "location": "StepDefinition.checkResult(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 22
    }
  ],
  "location": "StepDefinition.statusCodeCheck(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "application/json",
      "offset": 24
    }
  ],
  "location": "StepDefinition.generateResult(String)"
});
formatter.result({
  "status": "skipped"
});
});