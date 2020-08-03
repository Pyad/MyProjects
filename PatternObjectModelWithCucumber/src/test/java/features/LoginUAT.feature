Feature: Login into Leaftaps Application
Background: 
Given Launch the browser
And Load the URL
And Maximize the window
And Set the Implicit wait

Scenario: Login with system Admin (+ve)
Given Enter the UserName as DemoSalesManager
And Enter the Password as crmsfa
When Click on Login button
Then Login should be successful

Scenario: Login with DemoSalesManager (+ve)
Given Enter the UserName as DemoSalesManager
And Enter the Password as crmsfa
When Click on Login button
Then Login should be successful

Scenario: Login with system Admin (-ve)
And Enter the UserName as Gopi M bad user
And Enter the Password as crmsfa
When Click on Login button
But Validate Login for failure









 