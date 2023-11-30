Feature: Verify Customer Login functionality
@Sanity
Scenario Outline: Verify Customer Login functionality happy path
Given I am in landing page
When I Click on Login menu
And Click on Customer Login
And I am Taking data from excel "<SheetName>" and <RowNumber>
Then I Enter UserId           
And I Enter Password
And I Click on Login Button
Then Verify that I am in CUSTOMER Home Page

  Examples:
  |SheetName | RowNumber |
  |automation |  0      |





