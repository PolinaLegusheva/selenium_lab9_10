import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.sql.DriverManager;

public class CommonTest {
    protected WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setupBrowser(){
        WebDriverManager.chromedriver().setup();
        driver.manage().window().maximize();

    }

    @AfterSuite(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
    }
}
