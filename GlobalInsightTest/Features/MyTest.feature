Feature: Use the website to find restaurants
            So that I can order food
            As a hungry customer
            I want to be able to find restaurants in my area
            

Scenario: Valiadate the error message upon entering wrong postal code

Given I enter an invalid postal code as "abcdefg"
When I try to search for restaurants
Then I should see an error message

Scenario: Search for restaurants in an area

Given I want food in "AR51 1AA"
When I search for restaurants
Then I should see some restaurants in the area


Scenario: Validate that tab keys also work for entering a postal code
Given I enter a valid postal code in the search box
When I press ENTER key
Then I should see some restaurants in the area




           
