package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;
import java.util.Random;

public class SearchResultsPage {
   
    WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchButton;

    @FindBy(xpath = "//a[@class='sortOption']")
    List<WebElement> sortOptions;

    @FindBy(xpath = "//a[@class='nextPage']")
    WebElement nextPageButton;

    @FindBy(xpath = "//div[@class='product']")
    List<WebElement> products;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchForProduct(String query) {
        searchBox.sendKeys(query);
        searchButton.click();
    }

    public void iterateThroughProductPages(int pages) {
        for (int i = 0; i < pages; i++) {
            List<WebElement> products = driver.findElements(By.xpath("//div[@class='product']"));
            for (WebElement product : products) {
                System.out.println(product.getText());
            }
            if (nextPageButton.isDisplayed()) {
                nextPageButton.click();
            } else {
                break;
            }
        }
    }

    public void verifyProductDetails() {
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='product']"));
        for (WebElement product : products) {
            WebElement productName = product.findElement(By.xpath(".//h2[@class='productName']"));
            WebElement productPrice = product.findElement(By.xpath(".//span[@class='productPrice']"));
            if (productName.getText().isEmpty() || productPrice.getText().isEmpty()) {
                System.out.println("Product details are missing for: " + product.getText());
            } else {
                System.out.println("Product details verified for: " + productName.getText());
            }
        }
    }

    public void getSortOptions() {
        for (WebElement option : sortOptions) {
            System.out.println("Sort option available: " + option.getText());
        }
    }

    public void selectRandomSortOption() {
        Random random = new Random();
        int index = random.nextInt(sortOptions.size());
        WebElement randomOption = sortOptions.get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", randomOption);
    }
}
