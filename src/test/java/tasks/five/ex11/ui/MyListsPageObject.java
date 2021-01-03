package tasks.five.ex11.ui;

import io.appium.java_client.AppiumDriver;
import tasks.five.ex11.Platform;
import tasks.five.ex11.ui.factories.ArticlePageObjectFactory;
import tasks.five.ex11.ui.factories.SearchPageObjectFactory;

abstract public class MyListsPageObject extends MainPageObject {

    protected static String
            LOCATOR_SUBTITLE,
            LOCATOR_SUBTITLE_TWO,
            FOLDER_BY_NAME_TPL,
            CLOSE_SYNC_ARTICLE_BUTTON,
            ARTICLE_BY_TITLE_TPL;

    private static String getFolderXpathByName(String name_of_folder)
    {
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedXpathByTitle(String article_title)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    public MyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot find folder by name " + name_of_folder,
                5
        );
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getSavedXpathByTitle(article_title);
        this.waitForElementPresent(
                article_xpath,
                "Cannot find saved article by title " + article_title,
                15
        );
    }

    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getSavedXpathByTitle(article_title);
        this.waitForElementNotPresent(
                article_xpath,
                "Saved article still present with title" + article_title,
                15
        );
    }

    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getSavedXpathByTitle(article_title);
        this.swipeElementToLeft(
                article_xpath,
                "Cannot find saved article"
        );

        if(Platform.getInstance().isIOS()) {
            this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find saved article");
        }
        this.waitForArticleToDisappearByTitle(article_title);
    }

    public void clickCloseSyncArticle()
    {
        this.waitForElementAndClick(CLOSE_SYNC_ARTICLE_BUTTON, "Cannot find close button", 5);
    }

    public void saveArticleToMyListToNewFolder(String search_word, String article_title, String name_of_folder)
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_word);
        SearchPageObject.clickByArticleWithSubstring(article_title);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        ArticlePageObject.waitForTitleElement(LOCATOR_SUBTITLE);


        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }


        ArticlePageObject.closeArticle();

    }

    public void saveArticleToMyListToOldFolder(String search_word, String article_title, String name_of_folder)
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine(search_word);
        SearchPageObject.clickByArticleWithSubstring(article_title);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);


        ArticlePageObject.waitForTitleElement(LOCATOR_SUBTITLE_TWO);


        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToOldList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }

        ArticlePageObject.closeArticle();

    }
}
