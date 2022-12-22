
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import swisstime.pages.CatalogPage;
import swisstime.pages.HomePage;

import java.util.Locale;

import static swisstime.pages.constatnts.NamesConsts.*;
import static swisstime.pages.constatnts.PagesURL.*;

public class SearchByInputLineTest {
    WebDriver driver;
    @BeforeTest
    public void driverTest(){
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
    }
    @Test
    public void testAdditionToCart() throws InterruptedException {
        driver.get(HOME_PAGE);
        HomePage homePage = new HomePage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);
        String expectedText = WOMEN_SHOES_TITLE.toUpperCase(Locale.ROOT);

        homePage.enterNameOfSearch(WOMEN_SHOES_TITLE);
        String res = catalogPage.getTextFromTitle();

        Assert.assertTrue(res.toUpperCase(Locale.ROOT).contains(expectedText));
    }
    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
