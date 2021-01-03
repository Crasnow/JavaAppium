package tasks.four.ex8.tests;

import org.junit.Test;
import tasks.four.ex8.CoreTestCase;
import tasks.four.ex8.ui.SearchPageObject;


public class SearchTests extends CoreTestCase {

    @Test
    public void testCancelSearch() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.clickSearchLine();
        SearchPageObject.writeWords("Python");
        hideKeyboard();
        SearchPageObject.countSearchResults("3");
        SearchPageObject.clickCancelButton();
        SearchPageObject.waitForCancelButtonToDisappear();
    }

    @Test
    public void testAssertTitle() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.clickSearchLine();
        SearchPageObject.writeWords("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
        SearchPageObject.assertElementPresent();
    }
}
