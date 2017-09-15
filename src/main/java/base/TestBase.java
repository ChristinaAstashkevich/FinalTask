package base;

import driver.LocalDriverStategy;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import pages.MailPage;


public class TestBase extends LocalDriverStategy {

    public WebDriver driver;
    public LoginPage loginPage;
    public MailPage mailPage;

    protected TestBase() {
        super();
    }


    @BeforeClass
    public void setUp(){
        this.driver = LocalDriverStategy.getInstance();
        this.loginPage = new LoginPage(driver);
        this.mailPage = new MailPage(driver);
    }

    @AfterMethod
    public void logOut() {
        mailPage.goToHeader().signOut();
    }

    @AfterClass
    public void closeBrowser() {
        driver.close();
    }

}
