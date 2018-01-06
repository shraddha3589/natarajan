$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("testRunner/login.feature");
formatter.feature({
  "line": 1,
  "name": "Login",
  "description": "In order to Login\r\nAs a User\r\nI want to know the credentials",
  "id": "login",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 7,
  "name": "I am trying to log into magnetocommerce web page",
  "description": "",
  "id": "login;i-am-trying-to-log-into-magnetocommerce-web-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "I am on www.magentocommerce.com web Page",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I enter right credentials",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I should log into profile page",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "I am on www.magentocommerce.com web Page",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I enter wrong credentials",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I should remain on the same page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginTests.LaunchPage()"
});
formatter.result({
  "duration": 21474591104,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "right",
      "offset": 8
    }
  ],
  "location": "LoginTests.IEnter(String)"
});
formatter.result({
  "duration": 16414386490,
  "status": "passed"
});
formatter.match({
  "location": "LoginTests.SuccessLogIn()"
});
formatter.result({
  "duration": 1626697303,
  "status": "passed"
});
formatter.match({
  "location": "LoginTests.LaunchPage()"
});
formatter.result({
  "duration": 17473307695,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "wrong",
      "offset": 8
    }
  ],
  "location": "LoginTests.IEnter(String)"
});
formatter.result({
  "duration": 11240638170,
  "status": "passed"
});
formatter.match({
  "location": "LoginTests.InvalidLogin()"
});
formatter.result({
  "duration": 940052425,
  "status": "passed"
});
});