
import org.testng.Assert;
import org.testng.annotations.Test;
import swisstime.pages.CatalogPage;
import swisstime.pages.HomePage;
import static swisstime.pages.constatnts.NamesConsts.*;
import static swisstime.pages.constatnts.PagesURL.*;

public class SearchByInputLineTest extends CommonTest{
    @Test
    public void testAdditionToCart() throws InterruptedException {
        driver.get(HOME_PAGE);
        HomePage homePage = new HomePage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);
        String expectedText = WOMEN_SHOES_TITLE;

        homePage.enterNameOfSearch("women shoes");
        String res = catalogPage.getTextFromTitle();

        Assert.assertEquals(res, expectedText);
    }
}
