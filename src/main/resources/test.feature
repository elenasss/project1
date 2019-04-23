Feature: Login page

  @test
  Scenario: Login to the admin account
    Given the user is on the landing page
    When the user login with username "admin" and password "parola123!"
    Then the user is transferred to main admin page
