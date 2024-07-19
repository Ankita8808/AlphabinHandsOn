Feature: Myntra Product Browsing and Reviews

Scenario: Browse through different product categories (Positive)
  Given I am on the Myntra homepage
  When I navigate to the "Women's Clothing" category
  Then I should see a list of subcategories (e.g., Dresses, Tops, etc.)
  When I navigate to a specific subcategory (e.g., Dresses)
  Then I should see a list of available dresses

Scenario: Search for unavailable size (Negative)
  Given I am on the product details page for a specific dress
  When I try to select a size that is out of stock
  Then I should see a message indicating the size is unavailable

Scenario: Iterate through product pages on a search result (Loop)
  Given I am on the search results page for "Men's Shoes"
  When I iterate through the first 3 product pages on the search results
  Then for each product page, I should be able to view product details (name, price, etc.)

Scenario: Select a random sort option from available options (Array)
  Given I am on the search results page for "Watches"
  When I get all available sort options (e.g., Price - Low to High) and store them in an array
  Then I should be able to randomly select a sort option from the array and apply it

Scenario: Verify recently viewed items section uses a Set (Collection)
  Given I am on the Myntra homepage
  When I view a few different product pages (assuming Myntra uses a Set to avoid duplicates)
  Then I should see a "Recently Viewed" section on the homepage
  And the displayed items should be a unique subset of the recently viewed products (avoiding duplicates as expected with a Set)
