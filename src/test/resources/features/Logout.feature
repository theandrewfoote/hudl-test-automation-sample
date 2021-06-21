@feature:logout @implemented
  Feature: As a coach/athlete, I want to be able to log out of the Hudl application to ensure security
    To verify the ability to log out of Hudl, and ensure the sessions are closed

    Background: Set up a the system so a user is logged in
      Given a valid user is logged into Hudl

    Scenario: Verify a user can log out and return to the Hudl website homepage
      To check that the logging out option in the user interface successfully logs out the current user and returns
      the user to the Hudl homepage
      When logging out of Hudl
      Then the user is returned to the Hudl front web page

    Scenario: Verify cookies are removed after logging out
      For security reasons, we want to ensure cookies (ident) related to the previously logged in user are removed
      When logging out of Hudl
      Then cookies that relate to the user who was logged in no longer exist in the browser