package SearchTest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SeleniumSearchResultsPage extends AbstractPage{
    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]")
    private List<WebElement> countSearchResult;

    public SeleniumSearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public int countSearchResults() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]")));
        return countSearchResult.size();
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
