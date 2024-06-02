package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AuthenticationScreen extends BaseScreen {

    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    MobileElement inputEmailField;
    @FindBy(id = "com.sheygam.contactapp:id/inputPassword")
    MobileElement inputPasswordField;
    @FindBy(id = "com.sheygam.contactapp:id/regBtn")
    MobileElement registrationButton;
    @FindBy(id = "com.sheygam.contactapp:id/loginBtn")
    MobileElement loginButton;

    public AuthenticationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }




    public <T extends BaseScreen> T clickLoginButton(){
        loginButton.click();
        List<MobileElement> list = driver.findElements(By.xpath("//*[@resource-id='android:id/alertTitle']"));
        if(list.size()>0){
            driver.findElement(By.xpath("//*[@resource-id='android:id/button1']")).click();
            return (T) new AuthenticationScreen(driver);
        }
        else {return (T) new ContactListScreen(driver);}
    }

    public <T extends BaseScreen> T clickByRegistrationButton(){
        registrationButton.click();
        List<MobileElement> list = driver.findElements(By.id("android:id/alertTitle"));
        if(list.size()>0){
            driver.findElement(By.id("android:id/button1")).click();
            return (T) new AuthenticationScreen(driver);
        }
        return (T) new ContactListScreen(driver);
    }

}
