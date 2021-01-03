package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObject extends MainPageObject {

    private static final String
            STEP_LEARN_MORE_LINK = "xpath://XCUIElementTypeStaticText[@name='Learn more about Wikipedia']",
            STEP_NEXT_LINK = "xpath://XCUIElementTypeButton[@name='Next']",
            STEP_NEW_WAYS_TO_EXPLORE_TEXT = "xpath://XCUIElementTypeStaticText[@name='New ways to explore']",
            STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK = "xpath://XCUIElementTypeStaticText[@name='Add or edit preferred languages']",
            STEP_LEARN_MORE_ABOUT_DATA_COLLECTED = "xpath://XCUIElementTypeStaticText[@name='Learn more about data collected']",
            STEP_GET_STARTED_LINK = "xpath://XCUIElementTypeStaticText[@name='Get started']",
            SKIP = "xpath://XCUIElementTypeButton[@name='Skip']";


    public WelcomePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void waitForLearnMoreLink() {
        this.waitForElementPresent(STEP_LEARN_MORE_LINK, "Cannot find 'Learn more about Wikipedia' link", 15);
    }

    public void clickNextButton() {
        this.waitForElementAndClick(STEP_NEXT_LINK, "Cannot find and click 'Next' button", 15);
    }

    public void waitForNewWaysToExploreLink() {
        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE_TEXT, "Cannot find 'New ways to explore' link", 15);
    }

    public void waitForAddOrEditPreferredLangText() {
        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK, "Cannot find 'Add or edit preferred languages' link", 15);
    }

    public void waitForLearnMoreAboutDataCollectedLink() {
        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED, "Cannot find 'Learn more about data collected' link", 15);
    }

    public void clickGetStartedButton() {
        this.waitForElementAndClick(STEP_GET_STARTED_LINK, "Cannot find and click 'Get started' button", 15);
    }

    public void clickSkip() {
        this.waitForElementAndClick(SKIP, "Cannot find and click 'Skip' button", 5);
    }

}
