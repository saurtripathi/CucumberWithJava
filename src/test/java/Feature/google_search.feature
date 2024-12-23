@ignore
  Feature: Search page feature
    This feature lists all the scenarios on search page

  @Smoke
    Scenario Outline: : While entering the text in Search text box it should work
      Given Launch Google search page
      When Enter the "<text>" in searchbox
      Then Entered text should match the actual text
      Examples:
      | text  |
      | selenium  |
      | python  |
      | data science  |

  @Regression
    Scenario: Verify the Sign in link present
      Given Launch Google search page
      When Click on Sign in link
      Then Navigate to Sign in page
  #To filter scenario to run in Cucumber use
  #test "-Dcucumber.filter.tags=not @Regression"
  #  To run scenario mentioned by Regression or Smoke
  #test "-Dcucumber.options=--tags '@Regression or  @Smoke' "



