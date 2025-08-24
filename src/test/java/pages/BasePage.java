package pages;

import helperMethods.ElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    private WebDriver driver;
    public ElementHelper elementHelper;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        PageFactory.initElements(driver,this);
    }
}
