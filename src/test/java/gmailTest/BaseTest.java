package gmailTest;

import com.epam.bo.LoginBusinessObject;
import com.epam.bo.MessagesBusinessObject;
import com.epam.factory.DriverManager;
import com.epam.utils.PropertyFile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.epam.utils.Constants.URL;

public class BaseTest {
    protected static LoginBusinessObject loginBusinessObject;
    protected static MessagesBusinessObject messagesBusinessObject;

    @BeforeMethod
    public void setUp() {
        DriverManager.getDriver().get(PropertyFile.getProperty(URL));
        loginBusinessObject = new LoginBusinessObject();
        messagesBusinessObject = new MessagesBusinessObject();
    }

    @AfterMethod
    public void turnDown() {
        DriverManager.quitDriver();
    }
}
