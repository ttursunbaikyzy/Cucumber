Feature: Searching the employee

  Background:
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM option

  @smoke1
  Scenario: Search Employee by Id
    #Given open the browser and launch HRMS application
    #When user enters valid email and valid password
    #And click on login button
    #When user clicks on PIM option
    When user enters valid employee id
    And clicks n search button
    And user see employee information is displayed
    #And close the browser

  @smoke1
  Scenario: Search Employee by Job Title
    #Given open the browser and launch HRMS application
    #When user enters valid email and valid password
    #And click on login button
    #When user clicks on PIM option
    When user selects Job Title
    And clicks n search button
    And user see employee information is displayed
    #And close the browser


  #Background: This is used to define all the common steps that multiple scenarios have in the same feature file, till the time flow is not broken
  #          : It's the clubbing of common steps in different scenarios of a feature file till flow is not broken
  # 1. Hard code
  # 2. Config file
  # -------- Cucumber itself provides multiple option through which we can feed data from
  # feature file into Step Definition-----------
  # 3. Regular Expressions
       # put the data in double quotes [""]
  # 4. Scenario Outline
       # Provides you an alternative to Data driven testing
       # Also supports parameterization

  #=================PARAMETERIZATION=========================
  # Executing the same test case with multiple data