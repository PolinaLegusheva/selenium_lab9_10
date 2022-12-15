package swisstime.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstractPage{
    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(className = "searchinput___19uW0")
    WebElement searchButton;


   public HomePage enterNameOfSearch(String line){
       searchButton.click();
       wait.until(ExpectedConditions.elementToBeClickable(searchButton));
       searchButton.sendKeys(line, Keys.ENTER);
       return this;
   }
}
