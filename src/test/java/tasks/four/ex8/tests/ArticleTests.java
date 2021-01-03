package tasks.four.ex8.tests;

import org.junit.Test;
import tasks.four.ex8.CoreTestCase;
import tasks.four.ex8.ui.ArticlePageObject;
import tasks.four.ex8.ui.SearchPageObject;

public class ArticleTests extends CoreTestCase {

    @Test
    public void testSaveTwoArticleToMyList() throws InterruptedException {

        String title_saved = "Object-oriented programming language";


        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring(title_saved);

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String name_of_folder = "Learning programming";
        ArticlePageObject.addArticleToNewList(name_of_folder);
        ArticlePageObject.closeArticle();

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Python");
        SearchPageObject.clickByArticleWithSubstring("General-purpose programming language");
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.addArticleToOldList(name_of_folder);

        ArticlePageObject.closeArticle();

        ArticlePageObject.removeSecondArticle();
        ArticlePageObject.clickByArticleForTitle(title_saved.toLowerCase());
        ArticlePageObject.assertTitle(title_saved);
    }
}

