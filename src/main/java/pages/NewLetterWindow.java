package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static pages.MailPage.message;
import static pages.MailPage.subject;

public class NewLetterWindow extends PageBase {
    public NewLetterWindow(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = ".//textarea[@aria-label='To']")
    private WebElement forWhomField;
    @FindBy(xpath = ".//input[@placeholder='Subject']")
    private WebElement subjectField;
    @FindBy(css = "div[aria-label='Message Body']")
    private WebElement letterBodyWindow;
    @FindBy(xpath = ".//div[@role='button' and text()='Send']")
    private WebElement sendButton;


    public MailPage sendSomeMail(String forWhom) {
        forWhomField.sendKeys(forWhom);
        subjectField.sendKeys(subject);
        letterBodyWindow.sendKeys(message);
        sendButton.click();
        return new MailPage(driver);
    }

    public MailPage sendAndVerifySomeMail(String forWhom) {
        sendSomeMail(forWhom)
                .verifyMail();
        return new MailPage(driver);
    }

}