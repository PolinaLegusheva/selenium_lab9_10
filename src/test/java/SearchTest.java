import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SearchTest {
    private static WebDriver driver = new ChromeDriver();

    @BeforeTest
        public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test
    public void searchResultAreNotEmpty(){

            driver.get("https://www.adidas.com/us");

            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions
                            .presenceOfElementLocated(By.className("searchinput___19uW0")));
            List<WebElement> searchInput = driver.findElements(By.className("searchinput___19uW0"));
            searchInput.get(0).sendKeys("women shoes");

            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions
                            .presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/div/div[1]/div[2]/div[3]/div/div[2]/div[1]/div/form/input[1]")));
            List<WebElement> inputLine = driver.findElements(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/div/div[1]/div[2]/div[3]/div/div[2]/div[1]/div/form/input[1]"));
            inputLine.get(0).click();

            new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions
                            .presenceOfElementLocated(By.className("searchinput___19uW0")));
            List<WebElement> searchEnter = driver.findElements(By.className("searchinput___19uW0"));
            searchEnter.get(0).sendKeys(Keys.RETURN);

            new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions
                            .presenceOfElementLocated(By.className("gl-modal__close")));
            List<WebElement> closeButton = driver.findElements(By.className("gl-modal__close"));
            closeButton.get(0).click();

            new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions
                            .presenceOfElementLocated(By.className("btn-clear-search___1iq5p")));
            List<WebElement> buttonClearSearch = driver.findElements(By.className("btn-clear-search___1iq5p"));
            buttonClearSearch.get(0).click();

            new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions
                            .presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]")));
            List<WebElement> searchResults = driver.findElements(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]"));
            System.out.println("Search results number for requested term: " + searchResults.size());

            Assert.assertTrue(searchResults.size()>0, "Search results are empty!");
    }

    @AfterTest
    public void exitDriver(){
        driver.quit();
    }
}
