package gmailTest;

import com.epam.entity.Message;
import com.epam.entity.User;
import com.epam.utils.JsonReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.asserter.MessageAsserter.*;

public class GmailTest extends BaseTest {
    private Message message = JsonReader.getMessage();

    @Test(dataProvider = "getUser")
    public void sendMessageTest(User user) {
        loginBusinessObject.logIn(user);
        messagesBusinessObject.sendMessage(message);
        assertThatAlertIsDisplayed(messagesBusinessObject.isAlertDisplayed());

        messagesBusinessObject.setCorrectEmailAndSendMessage(message.getCorrectRecipientEmail());
        String emailReturned = messagesBusinessObject.getEmailOfLastMessage();
        assertThatEmailsAreEquals(emailReturned, message.getCorrectRecipientEmail());
    }

    @DataProvider(parallel = true)
    public Object[] getUser() {
        List<User> testData = JsonReader.getUserList();
        return testData.toArray();
    }
}
