package ui.core;

import static utils.Constants.getBaseUrl;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ui.pages.LoginPage;
import utils.Waiter;

import java.lang.reflect.Method;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * The type Base test.
 */
public abstract class BaseTest {
    private final ThreadLocal<String> testName = new ThreadLocal<>();
    private static final LoginPage LOGIN_PAGE = new LoginPage();
    private static final String BASE_URL = getBaseUrl();


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
     */
    @BeforeEach
    public void init(){
        setUp();
    }

    /**
     * Tear down.
     */
    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }

    /**
     * Sets test name.
     *
     * @param method the method
     */
    @Before
    public void setTestName(Method method) {
        testName.set(String.format("%s#%s", method.getDeclaringClass().getSimpleName(), method.getName()));
    }

    /**
     * Gets test name.
     *
     * @return the test name
     */
    public String getTestName() {
        return testName.get();
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

