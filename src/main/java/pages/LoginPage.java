package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utility.PropertyProvider;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static final String USER1_LOGIN = PropertyProvider.getProperty("username1.username");
    public static final String USER2_LOGIN = PropertyProvider.getProperty("username2.username");
    public static final String USER3_LOGIN = PropertyProvider.getProperty("username3.username");
    public static final String PASSWORD = PropertyProvider.getProperty("password");

    @FindBy(css = "#identifierId")
    private WebElement loginField;
    @FindBy(css = "#identifierNext")
    private WebElement identifierButton;
    @FindBy(css = "#password")
    private WebElement passwordField;
    @FindBy(css = "#passwordNext")
    private WebElement passwordNext;

    public MailPage login(String login, String password) {
        //wait.until(ExpectedConditions.visibilityOf(loginField));
        //loginField.clear();
        loginField.sendKeys(login);
        wait.until(ExpectedConditions.elementToBeClickable(identifierButton));
        identifierButton.click();
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.click();
        passwordField.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(passwordNext));
        passwordNext.click();
        return new MailPage(driver);
    }

    public MailPage loginAsUser1(){
        login(USER1_LOGIN, PASSWORD);
        return new MailPage(driver);
    }

    public MailPage loginAsUser2(){
        login(USER2_LOGIN, PASSWORD);
        return new MailPage(driver);
    }

    public MailPage loginAsUser3(){
        login(USER3_LOGIN, PASSWORD);
        return new MailPage(driver);
    }

    public LoginPage checkSignOutSuccess() {
        Assert.assertTrue((driver.getTitle().toString().contains("Gmail")));
        return this;
    }

}
