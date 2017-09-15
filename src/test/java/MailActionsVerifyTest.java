import base.TestBase;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utility.TestListener;

@Listeners(TestListener.class)
public class MailActionsVerifyTest extends TestBase {

    private final String USER_1_LOGIN = "seleniumtests10";
    private final String USER_2LOGIN = "seleniumtests30";
    private final String MAIL_INDEX = "@gmail.com";
    private final String USER_PASSWORD = "060788avavav";


    @Test(description = "GM-3 Verify the ability to send emails")
    public void sendMailAbilityCheck() {
        loginPage.login(USER_1_LOGIN, USER_PASSWORD)
                .goToSendingNewLetter()
                .sendSomeMail(USER_2LOGIN + MAIL_INDEX)
                .goToHeader()
                .signOut()
                .login(USER_2LOGIN, USER_PASSWORD)
                .goToInputMessages()
                .verifyMail();
    }

    @Test(description = "GM-4 Verify that sent email appears in Sent Mail folder")
    public void sentMailAppearsInSentFolder() {
        loginPage.login(USER_1_LOGIN, USER_PASSWORD)
                .goToSendingNewLetter()
                .sendAndVerifySomeMail(USER_2LOGIN + MAIL_INDEX);
    }

    @Test(description = "GM-5 Verify that deleted email is listed in Trash")
    public void deletedMailIsListedInTrash() {
        loginPage.login(USER_1_LOGIN, USER_PASSWORD)
                .goToSendingNewLetter()
                .sendSomeMail(USER_2LOGIN + MAIL_INDEX)
                .deleteAndVerifyCurrentMessage();
    }
}
