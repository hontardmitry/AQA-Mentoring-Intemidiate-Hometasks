package ui.core;

import static utils.Constants.getBaseUrl;
import static utils.LogUtils.getLoggerForCurrentClass;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import ui.pages.LoginPage;
import utils.Waiter;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest {
    private static final LoginPage LOGIN_PAGE = new LoginPage();
    private static final String BASE_URL = getBaseUrl();
    private static final Logger LOGGER = getLoggerForCurrentClass();

    @BeforeEach
    public void init(TestInfo testInfo){
        WebDriverManager.chromedriver().setup();
        LOGGER.info("Test '{}' started.", testInfo.getDisplayName());
    }

    @AfterEach
    public void tearDown(TestInfo testInfo){
        Selenide.closeWebDriver();
        LOGGER.info("Test '{}' finished.", testInfo.getDisplayName());
    }

    public static void loginWithCredentials(String name, String password) {
        Selenide.open(BASE_URL);

        LOGIN_PAGE.getNameInput().should(Condition.visible).setValue(name);
        LOGIN_PAGE.getPasswordInput().should(Condition.visible).setValue(password);
        LOGIN_PAGE.getLoginButton().should(Condition.visible).click();

        Waiter.waitForReadyState();
    }
}

