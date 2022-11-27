import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class HelloWebDriver {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.adidas.com/us");

        WebElement searchInput = driver.findElement(By.className("searchinput___19uW0"));
        Thread.sleep(1000);
        searchInput.sendKeys("women shoes");

        WebElement searchEnter = driver.findElement(By.className("searchinput___19uW0"));
        searchEnter.sendKeys(Keys.RETURN);
        Thread.sleep(4000);

        WebElement closeButton = driver.findElement(By.className("gl-modal__close"));
        Thread.sleep(2000);
        closeButton.click();

        WebElement ButtonClearSearch = driver.findElement(By.className("btn-clear-search___1iq5p"));
        Thread.sleep(1000);
        ButtonClearSearch.click();

        WebElement sizeButton = driver.findElement(By.xpath("//*[@id=\"filters-panel\"]/div/div[1]"));
        Thread.sleep(2000);
        sizeButton.click();

        WebElement chooseSizeButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/div/div[2]/div/div[2]/div/div/div[1]/div[1]/div/div/div/div[1]/div/div[1]/div[2]/div/div/ul/li[5]"));

        chooseSizeButton.click();
        Thread.sleep(2000);

        WebElement chooseProduct = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div/div/div/div/div/a/div/p[1]"));
        Thread.sleep(2000);
        chooseProduct.click();
        chooseProduct.click();
        Thread.sleep(2000);

        WebElement addToBag = driver.findElement(By.xpath("//*[@id=\"add-to-bag\"]/button"));
        Thread.sleep(2000);
        addToBag.click();
        addToBag.click();

        WebElement viewBag = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div/div[2]/div/section/div[3]/a[1]"));
        Thread.sleep(2000);
        viewBag.click();

        Thread.sleep(2000);
        driver.quit();

    }
}
