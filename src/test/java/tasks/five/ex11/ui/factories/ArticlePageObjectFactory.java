package tasks.five.ex11.ui.factories;

import io.appium.java_client.AppiumDriver;
import tasks.five.ex11.Platform;
import tasks.five.ex11.ui.ArticlePageObject;
import tasks.five.ex11.ui.android.AndroidArticlePageObject;
import tasks.five.ex11.ui.ios.iOSArticlePageObject;

public class ArticlePageObjectFactory {

    public static ArticlePageObject get(AppiumDriver driver)
    {
        if(Platform.getInstance().isAndroid()){
            return new AndroidArticlePageObject(driver);
        } else {
            return new iOSArticlePageObject(driver);
        }
    }
}
