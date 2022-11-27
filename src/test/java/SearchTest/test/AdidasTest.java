package SearchTest.test;

import SearchTest.page.SeleniumAddToFavoritePage;
import SearchTest.page.SeleniumHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdidasTest {
    private static WebDriver driver = new ChromeDriver();

    @BeforeTest
        public void browserSetup(){

        driver = new ChromeDriver();
    }

    @Test
    public void addItemToCartTest() {
        boolean isAddedToFavorite = new SeleniumAddToFavoritePage(driver)
                .openPage()
                .addToFavorite()
                .isFavoriteWindowDisplayed();
        Assert.assertTrue(isAddedToFavorite , "Item is not added to the wishlist!");
    }

    @Test
    public void searchResultAreNotEmpty(){

        int expectedSearchResultsNumber = new SeleniumHomePage(driver)
                .openPage()
                .searchInput("woman shoes")
                .countSearchResults();

        Assert.assertTrue(expectedSearchResultsNumber > 0, "Search results are empty!");
    }

    @AfterTest
    public void exitDriver(){

        driver.quit();
    }
}
