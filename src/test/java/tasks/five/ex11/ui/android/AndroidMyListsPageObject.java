package tasks.five.ex11.ui.android;

import io.appium.java_client.AppiumDriver;
import tasks.five.ex11.ui.MyListsPageObject;

public class AndroidMyListsPageObject extends MyListsPageObject
{
    static {
        FOLDER_BY_NAME_TPL = "xpath://*[@text='{FOLDER_NAME}']";
        ARTICLE_BY_TITLE_TPL = "xpath://*[@text='{TITLE}']";
        LOCATOR_SUBTITLE = "xpath://*[@text='Java (programming language)']";
        LOCATOR_SUBTITLE_TWO ="xpath://*[@text='PHP']";
    }

    public AndroidMyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
