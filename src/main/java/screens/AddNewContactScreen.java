package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddNewContactScreen extends BaseScreen {
    public AddNewContactScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(id = "com.sheygam.contactapp:id/inputName")
    MobileElement inputNameField;
    @FindBy(id = "com.sheygam.contactapp:id/inputLastName")
    MobileElement inputLastNameField;
    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    MobileElement inputEmailField;
    @FindBy(id = "com.sheygam.contactapp:id/inputPhone")
    MobileElement inputPhoneField;
    @FindBy(id = "com.sheygam.contactapp:id/inputAddress")
    MobileElement inputAddressField;
    @FindBy(id = "com.sheygam.contactapp:id/inputDesc")
    MobileElement inputDescriptionField;
    @FindBy(id = "com.sheygam.contactapp:id/createBtn")
    MobileElement createButton;

    public AddNewContactScreen fillTheForm(Contact contact){
        waitForAnElement(createButton);
        inputNameField.sendKeys(contact.getName());
        driver.hideKeyboard();
        inputLastNameField.sendKeys(contact.getLastName());
        driver.hideKeyboard();
        inputEmailField.sendKeys(contact.getEmail());
        driver.hideKeyboard();
        inputPhoneField.sendKeys(contact.getPhone());
        driver.hideKeyboard();
        inputAddressField.sendKeys(contact.getAddress());
        driver.hideKeyboard();
        inputDescriptionField.sendKeys(contact.getDescription());
        driver.hideKeyboard();
        return new AddNewContactScreen(driver);
    }


    public <T extends BaseScreen> T submitContact(){

        createButton.click();

        List<MobileElement> list = driver.findElements(By.id("android:id/alertTitle"));
        if(list.size()>0){
            driver.findElement(By.id("android:id/button1")).click();
            return (T) new AddNewContactScreen(driver);
        }else{
            return (T) new ContactListScreen(driver);
        }


    }



}