package com.epam.entity;

public class Message {
    private String correctRecipientEmail;
    private String incorrectRecipientEmail;
    private String subject;
    private String messageText;

    public void setCorrectRecipientEmail(String correctRecipientEmail) {
        this.correctRecipientEmail = correctRecipientEmail;
    }

    public String getCorrectRecipientEmail() {
        return this.correctRecipientEmail;
    }

    public void setIncorrectRecipientEmail(String incorrectRecipientEmail) {
        this.incorrectRecipientEmail = incorrectRecipientEmail;
    }

    public String getIncorrectRecipientEmail() {
        return this.incorrectRecipientEmail;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageText() {
        return this.messageText;
    }
}
