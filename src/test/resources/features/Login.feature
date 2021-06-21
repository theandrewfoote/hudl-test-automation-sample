@feature:loginProcess @implemented
  Feature: As a coach/athlete, I want to be able to log in to Hudl easily so I can access my resources securely
    To verify the ability to log in to Hudl and to check the user experience of the log in process

    Background: Ensure no-one is logged in before each test
      Given No user is logged in

    Scenario: Verify ability to log in with valid credentials
    To check that a user with valid credentials can log in to Hudl and the email address is displayed in various
    locations in the UI
      When logging in to Hudl with valid credentials
      Then the user's email address is displayed in the navigation bar and in account settings

    Scenario: Verify inability to log in with incorrect password and correct message is displayed
    To check that logging in with an incorrect password fails and a generic message is returned to the user
      When logging in to Hudl with an incorrect password
      Then the user is informed that the log-in failed

    Scenario: Verify inability to log in with non-existent username and correct message is displayed
    To check that logging in with an non-existent username fails and a generic message is returned to the user
      When logging in to Hudl with a non-existent username
      Then the user is informed that the log-in failed

    Scenario: Verify inability to log in with blank password and correct message is displayed
    To check that logging in with a blank password fails and a generic message is returned to the user
      When logging in to Hudl with a blank password
      Then the user is informed that the log-in failed

    Scenario: Verify ability to log in by pressing Enter rather than clicking submit button
    To check a positive user experience for users who prefer using the keyboard
      When logging in to Hudl with valid credentials using just the keyboard
      Then the user's email address is displayed in the navigation bar and in account settings

    Scenario: Verify "Need Help" provides the user with useful information
      To check that the user can receive more help to get logged in
      When seeking help to log in
      Then the user is informed of how to progress

    Scenario: Verify "Need Help" keeps the email address populated
      To check that when seeking more help, the user's email address isn't wiped from the log in screen for a
    positive user experience
      When seeking help to log in having entered a username
      Then the email address is persisted on the login screen

    Scenario: Verify that "Remember Me" persists the username in the UI
      To check that the Remember Me functionality works as expected (NB: need to clear REMEMBER ME stion after test
      When logging in to Hudl with Remember Me selected and logging out
      Then the user's email address is prefilled as the username

    Scenario: Verify the password field is an input with type password
      To verify that passwords are obfuscated on the screen
      When preparing to log in with valid credentials
      Then the password field is of type password
