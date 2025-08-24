package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage{

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[text() = 'Book Store Application']")
    private WebElement bookStoreApplication;

    public void interactWithBookStoreApplicationMenu(){
        elementHelper.clickJSElement(bookStoreApplication);
        LoggerUtility.infoLog("The user clicks on Book Store Application Menu");
    }

}
