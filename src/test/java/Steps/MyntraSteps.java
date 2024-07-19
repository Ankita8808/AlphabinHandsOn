package Steps;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;
public class MyntraSteps {

	WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    ProductPage productPage;

    @Given("I am on the Myntra homepage")
    public void i_am_on_the_myntra_homepage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.myntra.com");
        homePage = new HomePage(driver);
    }

    @When("I navigate to the {string} category")
    public void i_navigate_to_the_category(String category) {
        homePage.navigateToCategory(category);
    }

    @Then("I should see a list of subcategories")
    public void i_should_see_a_list_of_subcategories() {
        homePage.verifySubcategories();
    }

    @When("I navigate to a specific subcategory {string}")
    public void i_navigate_to_a_specific_subcategory(String subcategory) {
        homePage.navigateToSubcategory(subcategory);
    }

    @Then("I should see a list of available dresses")
    public void i_should_see_a_list_of_available_dresses() {
        homePage.verifyAvailableDresses();
    }

    @Given("I am on the product details page for a specific dress")
    public void i_am_on_the_product_details_page_for_a_specific_dress() {
        productPage = new ProductPage(driver);
        productPage.navigateToProductPage();
    }

    @When("I try to select a size that is out of stock")
    public void i_try_to_select_a_size_that_is_out_of_stock() {
        productPage.selectOutOfStockSize();
    }

    @Then("I should see a message indicating the size is unavailable")
    public void i_should_see_a_message_indicating_the_size_is_unavailable() {
        productPage.verifyOutOfStockMessage();
    }

    @Given("I am on the search results page for {string}")
    public void i_am_on_the_search_results_page_for(String query) {
        searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.searchForProduct(query);
    }

    @When("I iterate through the first {int} product pages on the search results")
    public void i_iterate_through_the_first_product_pages_on_the_search_results(Integer pages) {
        searchResultsPage.iterateThroughProductPages(pages);
    }

    @Then("for each product page, I should be able to view product details")
    public void for_each_product_page_i_should_be_able_to_view_product_details() {
        searchResultsPage.verifyProductDetails();
    }

    @When("I get all available sort options and store them in an array")
    public void i_get_all_available_sort_options_and_store_them_in_an_array() {
        searchResultsPage.getSortOptions();
    }

    @Then("I should be able to randomly select a sort option from the array and apply it")
    public void i_should_be_able_to_randomly_select_a_sort_option_from_the_array_and_apply_it() {
        searchResultsPage.selectRandomSortOption();
    }

    
}

