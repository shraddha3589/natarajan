Feature: Login 
In order to Login
As a User
I want to know the credentials


Scenario: I am trying to log into magnetocommerce web page

Given I am on www.magentocommerce.com web Page
When I enter right credentials
Then I should log into profile page

Given I am on www.magentocommerce.com web Page
When I enter wrong credentials
Then I should remain on the same page69