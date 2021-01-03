package tasks.five.ex11.ui.ios;

import io.appium.java_client.AppiumDriver;
import tasks.five.ex11.ui.MyListsPageObject;

public class iOSMyListsPageObject extends MyListsPageObject
{
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeStaticText[contains(@name, '{TITLE}')]";
        CLOSE_SYNC_ARTICLE_BUTTON = "id:Close";
        LOCATOR_SUBTITLE = "id:Java (programming language)";
        LOCATOR_SUBTITLE_TWO = "id:Server-side scripting language created in 1994";
    }

    public iOSMyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
