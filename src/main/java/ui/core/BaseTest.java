package ui.core;

import static utils.Constants.getBaseUrl;
import static utils.LogUtils.getLoggerForCurrentClass;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import ui.pages.LoginPage;
import utils.Waiter;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * The type Base test.
 */
public abstract class BaseTest {
    private static final LoginPage LOGIN_PAGE = new LoginPage();
    private static final String BASE_URL = getBaseUrl();
    private static final Logger LOGGER = getLoggerForCurrentClass();

    /**
     * Set up.
     */
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    /**
     * Init.
     *
     * @param testInfo the test info
     */
    @BeforeEach
    public void init(TestInfo testInfo){
        setUp();
        LOGGER.info("WOW! Test '{}' started.", testInfo.getDisplayName());
    }

    /**
     * Tear down.
     *
     * @param testInfo the test info
     */
    @AfterEach
    public void tearDown(TestInfo testInfo){
        Selenide.closeWebDriver();
        LOGGER.info("Test '{}' finished.", testInfo.getDisplayName());
    }

    /**
     * Login with credentials.
     *
     * @param name     the name
     * @param password the password
     */
    public static void loginWithCredentials(String name, String password) {
        openPage(BASE_URL);

        LOGIN_PAGE.getNameInput().should(Condition.visible).setValue(name);
        LOGIN_PAGE.getPasswordInput().should(Condition.visible).setValue(password);
        LOGIN_PAGE.getLoginButton().should(Condition.visible).click();

        Waiter.waitForReadyState();
    }

    /**
     * Open page.
     *
     * @param url the url
     */
    public static void openPage(String url){
        Selenide.open(url);
        Waiter.waitForReadyState();
    }
}

