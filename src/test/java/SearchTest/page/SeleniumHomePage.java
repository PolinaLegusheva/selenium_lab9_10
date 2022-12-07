package SearchTest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumHomePage extends AbstractPage{
    private static final String HOMEPAGE_URL ="https://www.adidas.com/us";

    @FindBy(className = "searchinput___19uW0")
    private WebElement searchInput;


    @FindBy(className = "searchinput___19uW0")
    private WebElement searchEnter;


    public SeleniumHomePage(WebDriver driver) {
        super(driver);
    }

    public SeleniumHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                .presenceOfElementLocated(By.className("searchinput___19uW0")));
        return this;
    }

    public SeleniumSearchResultsPage searchInput(String term) {
        searchInput.sendKeys(term);
        searchEnter.sendKeys(Keys.RETURN);
        return new SeleniumSearchResultsPage(driver);
    }
}
