package com.epam.bo;

import com.epam.page.objects.GmailHomePage;
import com.epam.page.objects.SentMessagesPage;
import io.qameta.allure.Step;

import java.util.stream.Collectors;

public class MessagesBusinessObject {
    private final GmailHomePage gmailHomePage = new GmailHomePage();
    private final SentMessagesPage sentMessagesPage = new SentMessagesPage();

    @Step("Send message to email {0} with subject [{1}] and text [{2}]")
    public void sendMessage(String email, String subject, String text) {
        gmailHomePage.getComposeButton().getTextAndClick("Написати");
        gmailHomePage.getRecipientEmailField().setText(email);
        gmailHomePage.getMessageSubjectField().setText(subject);
        gmailHomePage.getMessageTextField().setText(text);
        gmailHomePage.getSendButton().click();
    }

    @Step("Get alert about wrong recipient email.")
    public boolean isAlertDisplayed() {
        return gmailHomePage.getAlert().getAlertText().equals("Помилка");
    }

    @Step("Set correct recipient email like {0}")
    public void setCorrectEmailAndSendMessage(String email) {
        gmailHomePage.getOkButton().click();
        gmailHomePage.getIncorrectEmail().click();
        gmailHomePage.getRecipientEmailField().clearAndSetText(email);
        gmailHomePage.getSendButton().click();
        gmailHomePage.getNotification().waitForNotification();
    }

    @Step("Get email of last message")
    public String getEmailOfLastMessage() {
        gmailHomePage.getLink().click();
        return sentMessagesPage.getEmailList()
                .stream()
                .limit(1)
                .map(text -> text.getAttribute("email"))
                .collect(Collectors.joining());
    }
}
