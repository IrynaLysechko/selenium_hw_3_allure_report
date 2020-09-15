package gmailTest;

import com.epam.factory.DriverManager;
import com.epam.utils.PropertyFile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import static com.epam.utils.Constants.URL;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverManager.getDriver().get(PropertyFile.getProperty(URL));
    }

    @AfterMethod
    public void turnDown() {
        DriverManager.quitDriver();
    }
}
