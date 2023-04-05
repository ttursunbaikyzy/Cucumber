Feature: Employee

  @testcase2  
  Scenario: Adding a new Employee
    Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM options
    And user clicks on add employee button
    And user enters firstName and middleName and lastName
    #And user clicks on save button
