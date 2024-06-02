import config.AppiumConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class LaunchAppTest extends AppiumConfig  {

    @Test
    public void launchTest(){
        String version = new SplashScreen(driver).getCurrentVersion();
        Assert.assertTrue(version.contains("1.0.0"));
        System.out.println(version);
    }



}
