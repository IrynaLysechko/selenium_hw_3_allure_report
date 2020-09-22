package com.epam.page.objects;

import com.epam.decorator.elements.Alert;
import com.epam.decorator.elements.Button;
import com.epam.decorator.elements.Text;
import com.epam.decorator.elements.TextField;
import org.openqa.selenium.support.FindBy;

public class GmailHomePage extends AbstractPage {
    @FindBy(xpath = "//div[@class='z0']/*[@role='button']")
    private Button composeButton;

    @FindBy(xpath = "//textarea[@class='vO']")
    private TextField recipientField;

    @FindBy(name = "subjectbox")
    private TextField subjectField;

    @FindBy(xpath = "//div[@class='Am Al editable LW-avf tS-tW']")
    private TextField messageField;

    @FindBy(xpath = "//div[text()='Надіслати']")
    private Button sendButton;

    @FindBy(xpath = "//div[@class='Kj-JD-K7 Kj-JD-K7-bsT']/span[1]")
    private Alert alert;

    @FindBy(name = "ok")
    private Button acceptButton;

    @FindBy(css = "div.TK .aim:nth-child(4)")
    private Text sentMessagesLink;

    @FindBy(xpath = "//div[@class='oL aDm az9']")
    private Text incorrectEmail;

    @FindBy(xpath = "//span[text()='Лист надіслано.']")
    private Alert notification;

    public GmailHomePage clickComposeButton() {
        composeButton.click();
        return this;
    }

    public GmailHomePage setRecipientEmail(String email) {
        recipientField.setText(email);
        return this;
    }

    public GmailHomePage setMessageSubjectField(String subject) {
        subjectField.setText(subject);
        return this;
    }

    public GmailHomePage setMessageTextField(String text) {
        messageField.setText(text);
        return this;
    }

    public GmailHomePage clickSendButton() {
        sendButton.click();
        return this;
    }

    public GmailHomePage getIncorrectEmail() {
        incorrectEmail.click();
        return this;
    }

    public String getAlertText() {
        return alert.getAlertText();
    }

    public GmailHomePage clickOkButton() {
        acceptButton.click();
        return this;
    }

    public GmailHomePage clearRecipientEmailAndSetText(String email) {
        recipientField.clearAndSetText(email);
        return this;
    }

    public GmailHomePage getNotification() {
        notification.waitForNotification();
        return this;
    }

    public GmailHomePage clickSentMessageLink() {
        sentMessagesLink.click();
        return this;
    }
}
