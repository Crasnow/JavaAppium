package tasks.five.ex11.ui.ios;

import io.appium.java_client.AppiumDriver;
import tasks.five.ex11.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject {
    static {
        FOOTER_ELEMENT = "id:View article in browser";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "id:W";
        SECOND_ARTICLE_TITLE = "xpath://XCUIElementTypeApplication[@name=\"Wikipedia\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[2]";
    }

    public iOSArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
