package SearchTest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumAddToFavoritePage extends AbstractPage{
    public static String ADIDAS_WISHLIST_PAGE_URL = "https://www.adidas.com/us";

    @FindBy(xpath = "//*[@id=\"main-content\"]/div[8]/section/div[2]/section/div[2]/div/div[2]/div/div/div/div[1]/section/div/div/div/div/div/div")
    private WebElement addToFavoriteButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[1]/div/div/div[1]/div[2]/div[3]/div/div[2]/div[3]/a")
    private WebElement wishlistWindow;

    public SeleniumAddToFavoritePage(WebDriver driver) {
        super(driver);
    }

    public SeleniumAddToFavoritePage addToFavorite() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main-content\"]/div[8]/section/div[2]/section/div[2]/div/div[2]/div/div/div/div[1]/section/div/div/div/div/div/div")));
        addToFavoriteButton.click();
        return this;
    }

    public boolean isFavoriteWindowDisplayed(){
        WebElement wishlistWindow = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[1]/div[1]/div/div/div[1]/div[2]/div[3]/div/div[2]/div[3]/a")));
        return wishlistWindow.isDisplayed();
    }

    @Override
    public SeleniumAddToFavoritePage openPage() {
        driver.get(ADIDAS_WISHLIST_PAGE_URL);
        return this;
    }
}
