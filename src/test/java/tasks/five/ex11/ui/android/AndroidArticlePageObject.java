package tasks.five.ex11.ui.android;

import io.appium.java_client.AppiumDriver;
import tasks.five.ex11.ui.ArticlePageObject;

public class AndroidArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "id:org.wikipedia:id/view_page_title_text";
        SUBTITLE = "id:org.wikipedia:id/page_list_item_description";
        FOOTER_ELEMENT = "xpath://*[@text='View page in browser']";
        OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://android.widget.LinearLayout[@index='2']";
        ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button";
        MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
        MY_LIST_OK_BUTTON = "xpath://*[@text='OK']";
        EXTRA_MENU = "xpath://android.widget.LinearLayout[@index='4']";
        READING_LIST = "id:org.wikipedia:id/item_title";
        CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        MORE_OPTION_SECOND_ARTICLE = "xpath:(//android.widget.ImageView[@content-desc='More options'])[3]";
        REMOVE_ARTICLE = "id:org.wikipedia:id/reading_list_item_remove_text";
        MY_LISTS = "id:My lists";
    }

    public AndroidArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
