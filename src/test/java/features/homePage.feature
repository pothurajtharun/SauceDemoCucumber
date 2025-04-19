Feature: Verify sauce demo landing page.

  @HomePage
  Scenario: Check the hamburger menu button options in home page.
    Given User is on the hamburger menu.
    When Take all the elements in a list.
    Then Validate the elements in the hamburger menu.
