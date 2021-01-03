package tasks.five.ex11.ui;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tasks.five.ex11.Platform;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String
            TITLE,
            SUBTITLE,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            SECOND_ARTICLE_TITLE,
            MY_LIST_OK_BUTTON,
            EXTRA_MENU,
            MORE_OPTION_SECOND_ARTICLE,
            REMOVE_ARTICLE,
            READING_LIST,
            MY_LISTS,
            CLOSE_ARTICLE_BUTTON;


    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getReadingList(String substring) {
        return READING_LIST.replace("{SUBSTRING}", substring);
    }

    public WebElement waitForTitleElement(String title)
    {
        return this.waitForElementPresent(title, "Cannot find article title", 15);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement(TITLE);
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }
    }

    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of the article",
                    40
            );
        } else this.swipeUpTitleElementAppear(FOOTER_ELEMENT,
                "Cannot find the end of the article",
                40);
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to ad article to reading list ",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Got it' tip overlay",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of articles folder",
                5
        );

        this.waitForElementSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press OK button",
                5
        );
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close article, cannot find X link list",
                5
        );
    }

    public void addArticlesToMySaved()
    {
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to reading list", 5);
    }

    public void assertTitle(String title_saved)
    {

        WebElement element = waitForElementPresent(
                SUBTITLE,
                "Cannot find title of article",
                15);

        String title_element = element.getAttribute("text");

        Assert.assertEquals(
                "Saved title in folder have been changed article title",
                title_saved.toLowerCase(),
                title_element.toLowerCase()
        );
    }

    public void waitForSecondArticle()
    {
        this.waitForElementNotPresent(SECOND_ARTICLE_TITLE, "We have more 1 article", 5);
    }

    public void addArticleToOldList(String name_of_folder)  {

        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                15
        );

        waitForElementPresent(
                EXTRA_MENU,
                "Cannot find option to ad article to reading list ",
                5
        );


        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option to ad article to reading list ",
                5
        );

        String readingList = getReadingList(name_of_folder);
        this.waitForElementAndClick(
                READING_LIST,
                "Cannot find reading list:" + name_of_folder,
                5
        );
    }

    public void clickByMyLists()
    {
        this.waitForElementAndClick(MY_LISTS, "Cannot find My Lists", 10);
    }

    public void removeSecondArticle()
    {

        this.waitForElementAndClick(MORE_OPTION_SECOND_ARTICLE, "Cannot find More option button", 10);
        this.waitForElementAndClick(REMOVE_ARTICLE, "Cannot find Remove button", 10);
    }

}
