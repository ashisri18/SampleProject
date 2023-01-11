package setup;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.net.URL;

public class StartServer {
    protected URL server_url;
    protected AppiumServiceBuilder builder;
    protected AppiumDriverLocalService server;

    public StartServer() {
        builder = new AppiumServiceBuilder();
        builder.usingAnyFreePort();
        builder.withIPAddress("127.0.0.1");
        builder.withArgument(GeneralServerFlag.LOCAL_TIMEZONE);
//  if you are using Appium 1.xx and server not staring, then comment below line and re-run the project.
        builder.withArgument(() -> "--base-path", "/wd/hub");  // Added for Appium 2.xx

        server = AppiumDriverLocalService.buildService(builder);
        server_url = server.getUrl();
    }
}
