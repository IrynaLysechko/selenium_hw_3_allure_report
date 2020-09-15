package gmailTest;

import com.epam.bo.LoginBusinessObject;
import com.epam.bo.MessagesBusinessObject;
import com.epam.entity.User;
import com.epam.utils.JsonReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.asserter.MessageAsserter.*;
import static com.epam.utils.Constants.*;
import static com.epam.utils.PropertyFile.getProperty;

public class GmailTest extends BaseTest {

    @Test(dataProvider = "getUser")
    public void sendMessageTest(User user) {
        LoginBusinessObject loginBusinessObject = new LoginBusinessObject();
        loginBusinessObject.logIn(user);

        MessagesBusinessObject messagesBusinessObject = new MessagesBusinessObject();
        messagesBusinessObject.sendMessage(getProperty(INCORRECT_RECIPIENT), getProperty(SUBJECT), getProperty(MESSAGE));
        assertThatAlertIsDisplayed(messagesBusinessObject.isAlertDisplayed());

        messagesBusinessObject.setCorrectEmailAndSendMessage(getProperty(CORRECT_RECIPIENT_EMAIL));
        String emailReturned = messagesBusinessObject.getEmailOfLastMessage();
        assertThatEmailsAreEquals(emailReturned, getProperty(CORRECT_RECIPIENT_EMAIL));
    }

    @DataProvider(parallel = true)
    public Object[] getUser() {
        List<User> testData = JsonReader.getUserList();
        return testData.toArray();
    }
}
