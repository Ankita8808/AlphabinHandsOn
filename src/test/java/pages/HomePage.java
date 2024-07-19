package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	
    @FindBy(xpath = "//*[@class='desktop-categoryLink'][text()='Women']")
    WebElement womensClothingCategory;

    @FindBy(xpath = "//*[@class='desktop-categoryContainer']//a")
    List<WebElement> subcategories;

    @FindBy(xpath = "//a[@href='/women-dresses']")
    WebElement dressesSubcategory;

    @FindBy(xpath = "//div[@class='results-base']//div[@class='product-productMetaInfo']")
    List<WebElement> availableDresses;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToCategory(String category) {
        if (category.equals("Women's Clothing")) {
            womensClothingCategory.click();
        }
    }

    public void verifySubcategories() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(subcategories));
        if (subcategories.isEmpty()) {
            throw new AssertionError("Subcategories are not displayed");
        }
    }

    public void navigateToSubcategory(String subcategory) {
        if (subcategory.equals("Dresses")) {
            dressesSubcategory.click();
        }
    }

    public void verifyAvailableDresses() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(availableDresses));
        if (availableDresses.isEmpty()) {
            throw new AssertionError("No dresses are available");
        }
    }
    
   
}
