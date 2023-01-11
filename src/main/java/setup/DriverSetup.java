package setup;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class DriverSetup extends StartServer{

    public AppiumDriver driver;
    private DesiredCapabilities cap;

    @BeforeSuite(alwaysRun = true)
    public void initializeDriver(){
        server.start();
        driver = new AndroidDriver(server_url, setCapabilities());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterTest(alwaysRun = true)
    public void stopServer() {
        driver.quit();
        server.stop();
    }

    private DesiredCapabilities setCapabilities(){
        String capabilitiesFilePath = "src/main/resources/capabilities.json";
        return Capabilities.getDesiredCapabilities("emulator", capabilitiesFilePath);

        /*cap = new DesiredCapabilities();

        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("platformName", "android");
        cap.setCapability("platformVersion", "12.0");
        cap.setCapability("deviceName", "Pixel_5");
        cap.setCapability("noReset", false);
        cap.setCapability("fullReset", false);
        cap.setCapability("autoGrantPermissions", true);
        cap.setCapability("app", "src/main/resources/testApp.apk");
        cap.setCapability("appPackage", "io.selendroid.testapp");
        cap.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
        return cap;*/
    }
}
