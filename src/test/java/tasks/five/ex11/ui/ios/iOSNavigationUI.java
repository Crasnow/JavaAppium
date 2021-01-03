package tasks.five.ex11.ui.ios;

import io.appium.java_client.AppiumDriver;
import tasks.five.ex11.ui.NavigationUI;

public class iOSNavigationUI extends NavigationUI
{
    static {
        MY_LISTS_LINK = "id:Saved";
    }

    public iOSNavigationUI(AppiumDriver driver)
    {
        super(driver);
    }
}
