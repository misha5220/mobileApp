import config.AppiumConfig;
import models.Contact;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.AddNewContactScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class AddNewContactTests extends AppiumConfig {
    @Test
     public void addNewContactPositive(){
         ContactListScreen contactListScreen = new SplashScreen(driver).switchToAuthenticationScreen()
                 .fillEmailField("mymegamail@mail.com")
                 .fillPasswordField("MyPassword123!")
                 .clickLoginButton();

         Contact contact = Contact.createRandomContact();
         AddNewContactScreen addNewContactScreen = contactListScreen.clickToAddBtn();
         contactListScreen = addNewContactScreen.fillTheForm(contact).submitContact();
         Assert.assertTrue(contactListScreen.isContactAdded(contact));
     }


}
