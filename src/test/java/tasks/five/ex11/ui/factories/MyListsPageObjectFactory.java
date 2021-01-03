package tasks.five.ex11.ui.factories;

import io.appium.java_client.AppiumDriver;
import tasks.five.ex11.Platform;
import tasks.five.ex11.ui.MyListsPageObject;
import tasks.five.ex11.ui.android.AndroidMyListsPageObject;
import tasks.five.ex11.ui.ios.iOSMyListsPageObject;

public class MyListsPageObjectFactory
{
    public static MyListsPageObject get(AppiumDriver driver)
    {
        if(Platform.getInstance().isAndroid()) {
            return new AndroidMyListsPageObject(driver);
        } else {
            return new iOSMyListsPageObject(driver);
        }
    }
}
