package screenshots;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    private AppiumDriver driver;

    public ScreenshotUtil(AppiumDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot(String testMethod){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File nameFile = new File("screenshot/"+testMethod+timeStamp+".png");
        try {
            FileUtils.copyFile(scrFile,nameFile);
            System.out.println("screenshot saved!");
        } catch (IOException e ){
            throw new RuntimeException(e);
        }
    }


}
