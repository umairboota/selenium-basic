package qa.com.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.stream.Collectors;

public class DashboardPage {
    private WebDriver driver;

    // Locators for dashboard elements
    private By filterDropdown = By.className("product_sort_container");
    private By itemPrices = By.className("inventory_item_price");
    private By addToCartButtons = By.xpath("//button[contains(text(),'Add to cart')]");
    private By cartButton = By.className("shopping_cart_link");
    private By cartItems = By.className("cart_item");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to sort items from low to high
    public void sortItemsLowToHigh() {
        Select dropdown = new Select(driver.findElement(filterDropdown));
        dropdown.selectByVisibleText("Price (low to high)");
    }

    // Method to get item prices
    public List<Double> getItemPrices() {
        List<WebElement> prices = driver.findElements(itemPrices);
        return prices.stream()
                .map(price -> Double.valueOf(price.getText().replace("$", "")))
                .collect(Collectors.toList());
    }

    // Method to add first two items to the cart
    public void addFirstTwoItemsToCart() {
        List<WebElement> addToCartBtns = driver.findElements(addToCartButtons);
        addToCartBtns.get(0).click();
        addToCartBtns.get(1).click();
    }

    // Method to go to cart
    public void goToCart() {
        driver.findElement(cartButton).click();
    }

    // Method to get the number of items in the cart
    public int getNumberOfItemsInCart() {
        return driver.findElements(cartItems).size();
    }
}
