package com.epam.bo;

import com.epam.entity.Message;
import com.epam.page.objects.GmailHomePage;
import com.epam.page.objects.SentMessagesPage;
import io.qameta.allure.Step;

import java.util.stream.Collectors;

public class MessagesBusinessObject {
    private final GmailHomePage gmailHomePage = new GmailHomePage();
    private final SentMessagesPage sentMessagesPage = new SentMessagesPage();

    @Step("Send message to email {0} with subject [{1}] and text [{2}]")
    public void sendMessage(Message message) {
        gmailHomePage
                .clickComposeButton()
                .setRecipientEmail(message.getIncorrectRecipientEmail())
                .setMessageSubjectField(message.getSubject())
                .setMessageTextField(message.getMessageText())
                .clickSendButton();
    }

    @Step("Get alert about wrong recipient email.")
    public boolean isAlertDisplayed() {
        return gmailHomePage
                .getAlertText().equals("Помилка");
    }

    @Step("Set correct recipient email like {0}")
    public void setCorrectEmailAndSendMessage(String email) {
        gmailHomePage
                .clickOkButton()
                .getIncorrectEmail()
                .clearRecipientEmailAndSetText(email)
                .clickSendButton()
                .getNotification();
    }

    @Step("Get email of last message")
    public String getEmailOfLastMessage() {
        gmailHomePage.clickSentMessageLink();
        return sentMessagesPage.getEmailList()
                .stream()
                .limit(1)
                .map(text -> text.getAttribute("email"))
                .collect(Collectors.joining());
    }
}
