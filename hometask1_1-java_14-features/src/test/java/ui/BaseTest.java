package ui;

import static utils.enums.Constants.BASE_URL;
import static utils.enums.Constants.STANDARD_USER;
import static utils.enums.Constants.STANDARD_USER_PASSWORD;

import static java.lang.String.format;

import com.codeborne.selenide.Selenide;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import ui.pages.LoginPage;
import ui.pages.components.PageHeader;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest {
    protected static final Logger LOGGER =  Logger.getLogger(BaseTest.class);
    private static final LoginPage LOGIN_PAGE = new LoginPage();
    protected final static PageHeader PAGE_HEADER = new PageHeader();

    @BeforeEach
    public void init(TestInfo testInfo) {
        WebDriverManager.chromedriver().setup();
        LOGGER.info(format("Test '%s' started.", testInfo.getDisplayName()));
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        Selenide.closeWebDriver();
        LOGGER.info(format("Test '%s' finished.", testInfo.getDisplayName()));
    }

    public static void loginWithStandardUser() {
        Selenide.open(BASE_URL.getValue());

        LOGIN_PAGE.getNameInput().setValue(STANDARD_USER.getValue());
        LOGIN_PAGE.getPasswordInput().setValue(STANDARD_USER_PASSWORD.getValue());
        LOGIN_PAGE.getLoginButton().click();
    }
}

