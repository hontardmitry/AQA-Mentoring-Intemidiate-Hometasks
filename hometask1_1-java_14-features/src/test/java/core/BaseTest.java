package core;

import static utils.LogUtils.getLoggerForCurrentClass;
import static utils.enums.Constants.BASE_URL;
import static utils.enums.Constants.STANDARD_USER;
import static utils.enums.Constants.STANDARD_USER_PASSWORD;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import ui.pages.LoginPage;
import ui.pages.components.PageHeader;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest {
    private static final LoginPage LOGIN_PAGE = new LoginPage();
    protected static final Logger LOGGER = getLoggerForCurrentClass();
    protected final static PageHeader pageHeader = new PageHeader();

    @BeforeEach
    public void init(TestInfo testInfo) {
        WebDriverManager.chromedriver().setup();
        LOGGER.info("Test '{}' started.", testInfo.getDisplayName());
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        Selenide.closeWebDriver();
        LOGGER.info("Test '{}' finished.", testInfo.getDisplayName());
    }

    public static void loginWithStandardUser() {
        Selenide.open(BASE_URL.getValue());

        LOGIN_PAGE.getNameInput().setValue(STANDARD_USER.getValue());
        LOGIN_PAGE.getPasswordInput().setValue(STANDARD_USER_PASSWORD.getValue());
        LOGIN_PAGE.getLoginButton().click();
    }
}

