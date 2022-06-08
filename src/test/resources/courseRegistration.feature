Feature: Course registration form validation

  Scenario: Verify user can register for a course
    Given User visits the website and registration form is opened up
    When first name, middle name, last name and email field are present
    And user insert values at first name, middle name, last name and email field
    And select course Math101
    And clicks submit application
    Then user registration form is present