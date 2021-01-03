package tasks.five.ex11.tests;

import org.junit.Test;
import tasks.five.ex11.CoreTestCase;
import tasks.five.ex11.Platform;
import tasks.five.ex11.ui.ArticlePageObject;
import tasks.five.ex11.ui.MyListsPageObject;
import tasks.five.ex11.ui.NavigationUI;
import tasks.five.ex11.ui.factories.ArticlePageObjectFactory;
import tasks.five.ex11.ui.factories.MyListsPageObjectFactory;
import tasks.five.ex11.ui.factories.NavigationUIFactory;

public class MyListsTests extends CoreTestCase
{
    private static final String name_of_folder = "Learning programming";
    private static final String article_title = "Object-oriented programming language";


    @Test
    public void testSaveTwoArticleAndDeleteOneArticleToMyList() {

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);

        MyListsPageObject.saveArticleToMyListToNewFolder(
                "Java",
                article_title,
                name_of_folder);

        if (Platform.getInstance().isAndroid()) {
            MyListsPageObject.saveArticleToMyListToOldFolder(
                    "PHP",
                    "Scripting language focused on web development",
                    name_of_folder);
        } else {
            MyListsPageObject.saveArticleToMyListToOldFolder(
                    "PHP",
                    "Server-side scripting language created in 1994",
                    name_of_folder);
        }



        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);


        if (Platform.getInstance().isAndroid()) {
            MyListsPageObject.openFolderByName(name_of_folder);
            ArticlePageObject.removeSecondArticle();
            ArticlePageObject.assertTitle(article_title);
        } else {
            MyListsPageObject.clickCloseSyncArticle();
            MyListsPageObject.swipeByArticleToDelete(article_title);
            ArticlePageObject.waitForSecondArticle();
        }
    }
}
