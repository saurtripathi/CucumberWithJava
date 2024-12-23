@execute

  Feature: GeeksforGeeks landing page scenarios
    Scenario: Validating the Data Science (Live) link
      Given Launch GeeksForGeeks landing page
      When Hovering on Courses Menu
      Then For Student submenu should have Data Science (Live) link

    Scenario: Validate the Python link working
      Given Launch GeeksForGeeks landing page
      When Hovering on Courses Menu
      When Clicking on Pythin link
      Then Page for Python Tutorial lands

