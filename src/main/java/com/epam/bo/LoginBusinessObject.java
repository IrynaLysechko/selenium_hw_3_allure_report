package com.epam.bo;

import com.epam.entity.User;
import com.epam.page.objects.GmailLoginPage;
import io.qameta.allure.Step;

public class LoginBusinessObject {
    private final GmailLoginPage gmailLoginPage = new GmailLoginPage();

    @Step("Login with email {user.email} and password {user.password}")
    public void logIn(User user) {
        gmailLoginPage.getEmailField().setTextAndSend(user.getEmail());
        gmailLoginPage.getPasswordField().setTextAndSend(user.getPassword());
    }
}
