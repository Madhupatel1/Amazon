
@Sanity
Feature: Amazon login

  @Functionaltesting
  Scenario: Login and Logout 
    Given Open "Chrome" browser
    When launch "https://www.amazon.in/" site
    Then Amazon home page should be display
    And hover on mouse on login button
    And Click on Sign in button
    Then Login page should be display
    Then Enter Phone "7416846023"
    Then Enter password "Password@12345"
    And Enter string in searchbox
    And Enter logout button
    
