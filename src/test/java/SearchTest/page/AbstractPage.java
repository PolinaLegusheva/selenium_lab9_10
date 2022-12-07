package SearchTest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public abstract class AbstractPage {
    protected WebDriver driver;
    protected abstract AbstractPage openPage();
    protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(30);

    protected AbstractPage (WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
