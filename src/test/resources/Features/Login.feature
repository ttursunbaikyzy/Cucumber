Feature: Login Functionalities

  @smoke
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    Then user is logged in successfully
    #And close the browser

  @smoke2
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid username "admin" and valid password "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully
    #And close the browser


    #HOOKS: For defining pre and post steps in any Cucumber framework
    #     : This is always created inside the StepDefinitions folder
    #     : This class cannot be inherited
    #     : Hooks will take care of pre and post conditions irrespective of what goes in between the test steps