import org.testng.Assert;
import org.testng.annotations.Test;
import swisstime.pages.CatalogPage;

import static swisstime.pages.constatnts.NamesConsts.*;
import static swisstime.pages.constatnts.PagesURL.*;

public class SearchByNameTest extends CommonTest{
    @Test
    public void testik(){
        driver.get(CATALOG_PAGE);
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.putProductInCart().closePopUp().checkCart();
        String result = catalogPage.checkCartStatus();

        Assert.assertEquals(result, EMPTY_CART);
    }
}
