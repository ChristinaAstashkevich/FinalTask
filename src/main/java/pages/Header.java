package pages;

import base.PageBase;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Header extends PageBase {
    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//a[@role='button' and contains (@title, 'Account')]")
    private WebElement userAccontICO;
    @FindBy(xpath = ".//a[text()='Sign out']")
    private WebElement signOutButton;


    public LoginPage signOut() {

        userAccontICO.click();
        wait.until(ExpectedConditions.visibilityOf(signOutButton));
        signOutButton.click();
        try {
            alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (alertText.contains("Do you want")) {
                alert.accept();
            }
        } catch (NoAlertPresentException e) {
            userAccontICO.click();
            wait.until(ExpectedConditions.visibilityOf(signOutButton));
            signOutButton.click();
        }
        return new
                LoginPage(driver);
    }

    public Header checkLogInSuccess() {
        Assert.assertTrue(userAccontICO.isDisplayed());
        return this;
    }

}
