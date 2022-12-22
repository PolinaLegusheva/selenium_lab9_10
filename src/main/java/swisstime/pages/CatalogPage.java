package swisstime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CatalogPage extends AbstractPage {

    @FindBy(className = "heading___3g-L_")
    WebElement catalogTitle;

    @FindBy(className = "glass-product-card__wishlist")
    WebElement heartImg;

    @FindBy(className = "gl-modal__close")
    WebElement closePopUpButton;

    @FindBy(className = "addtobag___3ba1u")
    WebElement cartButton;

    @FindBy(className = "empty_cart_notification___3YKxr")
    WebElement cartStatus;

    public CatalogPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTextFromTitle() throws InterruptedException {
        return driver.getCurrentUrl();
    }

    public CatalogPage putProductInCart(){
        heartImg.click();
        return this;
    }

    public CatalogPage closePopUp(){
        wait.until(ExpectedConditions.elementToBeClickable(closePopUpButton));
        closePopUpButton.click();
        return this;
    }

    public CatalogPage checkCart(){
        cartButton.click();
        return this;
    }

    public String checkCartStatus(){

        return cartStatus.getText();
    }

}
