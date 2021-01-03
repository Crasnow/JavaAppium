package tasks.five.ex11.ui.factories;

import io.appium.java_client.AppiumDriver;
import tasks.five.ex11.Platform;
import tasks.five.ex11.ui.SearchPageObject;
import tasks.five.ex11.ui.android.AndroidSearchPageObject;
import tasks.five.ex11.ui.ios.iOSSearchPageObject;


public class SearchPageObjectFactory
{
    public static SearchPageObject get(AppiumDriver driver)
    {
        if(Platform.getInstance().isAndroid()){
            return new AndroidSearchPageObject(driver);
        } else {
            return new iOSSearchPageObject(driver);
        }
    }
}