package tasks.five.ex11.ui.factories;

import io.appium.java_client.AppiumDriver;
import tasks.five.ex11.Platform;
import tasks.five.ex11.ui.NavigationUI;
import tasks.five.ex11.ui.android.AndroidNavigationUI;
import tasks.five.ex11.ui.ios.iOSNavigationUI;

public class NavigationUIFactory
{
    public static NavigationUI get(AppiumDriver driver)
    {
        if(Platform.getInstance().isAndroid()){
            return new AndroidNavigationUI(driver);
        } else {
            return new iOSNavigationUI(driver);
        }
    }
}
