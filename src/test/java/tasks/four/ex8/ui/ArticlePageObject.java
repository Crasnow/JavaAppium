package tasks.four.ex8.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    private static final String
            MORE_OPTION_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
            TITLE = "org.wikipedia:id/view_page_title_text",
            READING_LIST = "org.wikipedia:id/item_title",
            OPTIONS_BUTTON = "//android.widget.ImageView[@content-desc='More options']",
            OPTIONS_ADD_TO_MY_SIT_BUTTON = "//android.widget.LinearLayout[@index='2']",
            EXTRA_MENU = "//android.widget.LinearLayout[@index='4']",
            ADD_TO_MY_LIST_OVERLAY = "org.wikipedia:id/onboarding_button",
            MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "//*[@text='OK']",
            CLOSE_ARTICLE_BUTTON = "//android.widget.ImageButton[@content-desc='Navigate up']",
            FIRST_ARTICLE = "(/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[2]/android.widget.LinearLayout",
            MORE_OPTION_SECOND_ARTICLE = "(//android.widget.ImageView[@content-desc='More options'])[3]",
            REMOVE_ARTICLE = "org.wikipedia:id/reading_list_item_remove_text";

    /* TEMPLATES METHODS */
    private static String getReadingList(String substring) {
        return READING_LIST.replace("{SUBSTRING}", substring);
    }

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void addArticleToNewList(String name_of_folder) throws InterruptedException {

        this.waitForElementAndClick(
                By.xpath(OPTIONS_BUTTON),
                "Cannot find button to open article options",
                15
        );

        waitForElementPresent(
                By.xpath(EXTRA_MENU),
                "Cannot find option to ad article to reading list ",
                5
        );


        this.waitForElementAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_SIT_BUTTON),
                "Cannot find option to ad article to reading list ",
                5
        );

        this.waitForElementAndClick(
                By.id(ADD_TO_MY_LIST_OVERLAY),
                "Cannot find 'Got it' tip overlay",
                5
        );

        waitForElementAndClear(
                By.id(MY_LIST_NAME_INPUT),
                "Cannot put text into articles folder input",
                5
        );

        this.waitForElementSendKeys(
                By.id(MY_LIST_NAME_INPUT),
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        this.waitForElementAndClick(
                By.xpath(MY_LIST_OK_BUTTON),
                "Cannot press OK button",
                5
        );

    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(By.id(TITLE), "Cannot find article title", 15);
    }

    public void closeArticle() {
        this.waitForElementAndClick(
                By.xpath(CLOSE_ARTICLE_BUTTON),
                "Cannot close article, cannot find X link list",
                5
        );
    }

    public void addArticleToOldList(String name_of_folder) throws InterruptedException {

        this.waitForElementAndClick(
                By.xpath(OPTIONS_BUTTON),
                "Cannot find button to open article options",
                15
        );

        waitForElementPresent(
                By.xpath(EXTRA_MENU),
                "Cannot find option to ad article to reading list ",
                5
        );


        this.waitForElementAndClick(
                By.xpath(OPTIONS_ADD_TO_MY_SIT_BUTTON),
                "Cannot find option to ad article to reading list ",
                5
        );

        String readingList = getReadingList(name_of_folder);
        this.waitForElementAndClick(
                By.id(READING_LIST),
                "Cannot find reading list:" + name_of_folder,
                5
        );
    }

    public void clickByArticleForTitle(String title)
    {
        this.waitForElementAndClick(By.xpath("//*[@text='" + title + "']"), "Cannot find article with title: " + title, 10);
    }

    public void removeSecondArticle()
    {
        MainPageObject MainPageObject = new MainPageObject(driver);

        MainPageObject.clickByMyLists();
        this.waitForElementAndClick(By.id(READING_LIST), "Cannot find My Lists", 10);
        this.waitForElementAndClick(By.xpath(MORE_OPTION_SECOND_ARTICLE), "Cannot More option button", 10);
        this.waitForElementAndClick(By.id(REMOVE_ARTICLE), "Cannot find Remove button", 10);
    }

    public void assertTitle(String title_saved)
    {

        WebElement element = waitForElementPresent(
                By.id("org.wikipedia:id/view_page_subtitle_text"),
                "Cannot find title of article",
                15);

        String title_element = element.getAttribute("text");

        Assert.assertEquals(
                "Saved title in folder have been changed article title",
                title_saved,
                title_element
        );
    }
}

