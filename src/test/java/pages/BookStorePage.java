package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStorePage extends BasePage{

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//span[text()='Book Store']")
    WebElement bookStoreButton;

    @FindBy(xpath = "//span[text()='Profile']")
    WebElement profileButton;

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login")
    WebElement userLoginButton;

    @FindBy(id = "newUser")
    WebElement newUserButton;

    public void interactWithLoginSubmenu(){
        elementHelper.clickJSElement(loginButton);
        LoggerUtility.infoLog("User clicks on the Login button");
    }

    public void interactWithBookStoreSubmenu(){
        elementHelper.clickJSElement(bookStoreButton);
        LoggerUtility.infoLog("User clicks on the Book Store button");
    }

    public void interactWithProfileSubmenu(){
        elementHelper.clickJSElement(profileButton);
        LoggerUtility.infoLog("User clicks on the Profile button");
    }

    public void userLogin(String nameOfUser, String userPassword){
        elementHelper.fillElement(userName,nameOfUser);
        LoggerUtility.infoLog("User enters the username: " + nameOfUser);
        elementHelper.fillElement(password,userPassword);
        LoggerUtility.infoLog("User enters the password: " + userPassword);
        elementHelper.clickJSElement(userLoginButton);
        LoggerUtility.infoLog("User is successfully logged in");
    }

}
