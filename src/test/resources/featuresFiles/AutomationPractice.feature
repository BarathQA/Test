
    Feature: Complete Order of T-Shirt

    Background: User lands on the login page
    Given User is on Login Page
    When User logs into application with valid credentials
        | barath_star81@yahoo.com | Sathyans2 |
    Then User should be logged in

    @functionality1
    Scenario: User Login to application and updates the firstname under Personal information section
    Given User navigates to the Firstname field under Personal information section in Accounts Page
    When User updates and saves the Firstname
        | MyFirstname | Sathyans2 |
    Then User is displayed with success message "Your personal information has been successfully updated."

    @functionality2
    Scenario: User orders for a T-shirt and verifies the order history page
    Given User navigates to the "T-Shirts" section and selects the t-shirt
    When User completes Tshirt purchase
    And User navigate back to the Order History Page
    Then User should see that his Order is displayed in order history page


