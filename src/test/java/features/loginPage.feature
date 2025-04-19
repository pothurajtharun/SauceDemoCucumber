Feature: Login to sauce demo website.

  @LoginPage
  Scenario Outline: Login with email and password.

    Given User is on sauce demo login page.
    When User entered the <email> and <password> into respective fields.
    Then Validate the Swag Labs title in the home page.
    Examples:
      | email | password |
      | standard_user | secret_sauce |