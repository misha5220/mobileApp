import config.AppiumConfig;
import models.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AddNewContactScreen;
import screens.ContactListScreen;
import screens.SplashScreen;
import screenshots.ScreenshotUtil;

public class LoginTest extends AppiumConfig {

    @Test
    public void loginPositiveTest(){
        ContactListScreen contactListScreen = new SplashScreen(driver).switchToAuthenticationScreen()
                .fillEmailField("mymegamail@mail.com")
                .fillPasswordField("MyPassword123!")
                .clickLoginButton();

        ScreenshotUtil screenshotUtil = new ScreenshotUtil(driver);
        screenshotUtil.takeScreenshot("loginTest");

        Assert.assertTrue(contactListScreen.isContactListActivityPresent());
    }

}