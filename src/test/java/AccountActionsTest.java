import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utility.PropertyProvider;
import utility.TestListener;

@Listeners(TestListener.class)
public class AccountActionsTest extends TestBase {

    private AccountActionsTest() {
        super();
    }

    @Override
    @AfterMethod
    public void logOut() {

    }


    @Test(description = "GM-1 Login to gmail with valid credentials as User seleniumtests10")
    public void logInTestUser1() {
        loginPage.loginAsUser1()
                .goToHeader()
                .checkLogInSuccess()
                .signOut();
    }

    @Test(description = "GM-1 Login to gmail with valid credentials as User seleniumtests30")
    public void logInTestUser2() {
        loginPage.loginAsUser2()
                .goToHeader()
                .checkLogInSuccess()
                .signOut();
    }

    @Test(description = "GM-1 Login to gmail with valid credentials as User seleniumtests40")
    public void logInTestUser3() {
        loginPage.loginAsUser3()
                .goToHeader()
                .checkLogInSuccess()
                .signOut();
    }


    @Test(description = "GM-2 Logout from gmail",
            dataProvider = "accountsData", dataProviderClass = PropertyProvider.class)
    public void logOutTest(String login, String password) {
        loginPage.login(login, password)
                .goToHeader()
                .signOut()
                .checkSignOutSuccess();
    }
}
