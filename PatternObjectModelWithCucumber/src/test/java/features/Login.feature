Feature: Login into Leaftaps Application

Scenario Outline: Login with system Admin (+ve)
Given Enter the UserName as <uName>
And Enter the Password as <pwd>
When Click on Login button
Then Login should be successful
Examples: 
|uName|pwd|
|DemoSalesManager|crmsfa|
|DemoCSR|crmsfa|

Scenario: Login with system Admin (-ve)
And Enter the UserName as Gopi M bad user
And Enter the Password as crmsfa
When Click Login button for Failure
#But Validate Login for failure









 