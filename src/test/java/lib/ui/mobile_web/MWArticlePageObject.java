package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#ca-watch";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:a[title='Remove this page from your watchlist']";
        SECOND_ARTICLE = "css:#mw-content-text > ul > li:nth-child(2)";
    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
