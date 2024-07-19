<img width="461" alt="Screenshot 2024-07-19 180822" src="https://github.com/user-attachments/assets/eeeb92eb-ab2b-4e49-8807-9fe0ed5f3468">"#AlphabinHandsOn" 
This project is a Selenium-based web automation framework that uses Cucumber BDD for testing the Myntra website. It includes features like browsing through product categories, checking for unavailable sizes, and more.

Features

- Cucumber BDD Framework: Uses Cucumber for writing tests in a human-readable format.
- Page Object Model (POM): Utilizes POM to keep the test code clean and maintainable.
- Retry Mechanism: Retries failed test cases.
- Logging: Includes logging for debugging purposes.
- Clear Documentation: Provides detailed instructions on how to set up and run tests.

Prerequisites

- Java (JDK 8 or above)
- Maven
- ChromeDriver (for running tests on Google Chrome)
- TestNG

Repository

git clone https://github.com/Ankita8808/alphabinHandsOn.git
cd alphabinHandsOn

Scenario
 Search for unavailable size (Negative) 
Given I am on the product details page for a specific dress
 When I try to select a size that is out of stock
 Then I should see a message indicating the size is unavailable
Note:Not able to automated thid scenario

 Scenario: Select a random sort option from available options (Array) 
Given I am on the search results page for "Watches"
 When I get all available sort options (e.g., Price - Low to High) and store them in an array
 Then I should be able to randomly select a sort option from the array and apply it
  Note: This scenario not able to perform.

Scenario: Verify recently viewed items section uses a Set (Collection)  
Updated Scenario
 
Given I am on the Myntra homepage
 When I view a few different product pages (assuming Myntra uses a Set to avoid duplicates)
 Then I should see a "Recently Viewed" section on the homepage
 And the displayed items should be a unique subset of the recently viewed products (avoiding duplicates as expected with a Set)
 Note: This scenario not able to perform.

 Integration Process

Integration Process

Project Setup:
Created a new Maven project.
Added necessary dependencies in the pom.xml file
Framework Structure:
Implemented the Page Object Model (POM) for better code management.
Created separate packages for test cases, page objects, utilities, and configurations.
Cucumber Integration:
Set up Cucumber feature files and step definitions.
Configured the Cucumber runner class for executing tests.

Write test cases:
Scenario: Browse through different product categories (Positive) 
Given I am on the Myntra homepage
 When I navigate to the "Women's Clothing" category
 Then I should see a list of subcategories (e.g., Dresses, Tops, etc.)
 When I navigate to a specific subcategory (e.g., Dresses)
 Then I should see a list of available dresses
 Status: Pass

Scenario: Search for unavailable size (Negative) 
Given I am on the product details page for a specific dress
 When I try to select a size that is out of stock
 Then I should see a message indicating the size is unavailable
 status:Not able to perform







 

 Scenario: Iterate through product pages on a search result (Loop) 
 Given I am on the search results page for "Men's Shoes"
 When I iterate through the first 3 product pages on the search results
 Then for each product page, I should be able to view product details (name, price, etc.)
 Status:Pass

Challenges and Deviations:

Search Functionality: The search results were not displayed due to a timeout issue.
Pagination: Only the first page of products was displayed due to a pagination issue.
Product Details: Several products did not display prices.
Sort Options: Sort options were not visible on the page.

















