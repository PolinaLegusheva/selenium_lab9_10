import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import swisstime.pages.CatalogPage;

import static swisstime.pages.constatnts.NamesConsts.*;
import static swisstime.pages.constatnts.PagesURL.*;

public class SearchByNameTest{
    WebDriver driver;

    @BeforeTest
    public void driverTest(){
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();
    }

    @Test
    public void testik(){
        driver.get(CATALOG_PAGE);
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.putProductInCart().closePopUp().checkCart();
        String result = catalogPage.checkCartStatus();

        Assert.assertEquals(result, EMPTY_CART.contains(result));
    }

    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
