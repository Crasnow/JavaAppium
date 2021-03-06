package tasks.four.ex8.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject{

    private static final String
            SEARCH_RESULTS_COUNTER = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@index='{SUBSTRING}']",
            SEARCH_LINE = "//*[contains(@text,'Search Wikipedia')]",
            SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_container",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']",
            SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
            SEARCH_INPUT = "//*[contains(@text,'Search…')]";

    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getSearchCounter(String substring)
    {
        return SEARCH_RESULTS_COUNTER.replace("{SUBSTRING}", substring);
    }

    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS */


    public void clickCancelButton()
    {
        this.waitForElementAndClick(By.id(SEARCH_CANCEL_BUTTON), "Cannot find and click search cancel button", 5);
    }

    public void waitForCancelButtonToDisappear()
    {
        this.waitForElementNotPresent(By.id(SEARCH_CANCEL_BUTTON), "Search cancel button is still present", 5);
    }

    public void clickSearchLine()
    {
        this.waitForElementAndClick(By.xpath(SEARCH_LINE), "Cannot find 'Search Wikipedia' input", 5);
    }

    public void writeWords(String search)
    {
        this.waitForElementSendKeys(By.xpath(SEARCH_LINE), search, "Cannot find search input", 5);
    }

    public void countSearchResults(String counter)
    {
        String search_result_counter = getSearchCounter(counter);
        this.waitForElementPresent(By.xpath(search_result_counter), "Cannot find article title", 15);
    }

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find and click search result with substring " + substring, 10);
    }

    public void initSearchInput()
    {
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 5);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element", 5);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementSendKeys(By.xpath(SEARCH_INPUT), search_line, "Cannot find and type into search input", 5);
    }

}
