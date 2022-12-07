package SearchTest.test;

import SearchTest.page.SeleniumAddToFavoritePage;
import SearchTest.page.SeleniumHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AdidasTest {

    public static final String AUTOMATE_USERNAME = "polinalegusheva_5iW1YE";
    public static final String AUTOMATE_ACCESS_KEY = "G9F9oF6SypBv538GeEp3";
    public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
    DesiredCapabilities caps = new DesiredCapabilities();

    @BeforeSuite
    public void configDevice()
    {
        caps.setCapability("os", "Windows");
        caps.setCapability("osVersion", "10");
        caps.setCapability("browserVersion", "107.0"); // test name
        caps.setCapability("browserName", "FireFox");
    }
    private static WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setupTest() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL(URL), caps);
    }
   // @BeforeTest
     //   public void browserSetup(){

     //   driver = new ChromeDriver();
    //}

    @Test
    public void addToFavoriteTest() {
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
