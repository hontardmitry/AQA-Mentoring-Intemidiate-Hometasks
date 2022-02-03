package ui.tests;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static utils.Constants.getBaseUrl;
import static utils.Constants.getInventoryUrl;
import static utils.Constants.getStandardUser;
import static utils.Constants.getStandardUserPwd;
import static utils.LogUtils.getLoggerForCurrentClass;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.Logger;
import ui.core.BaseTest;
import ui.pages.ShoppingCartPage;
import ui.pages.components.PageHeader;

import java.util.Map;

/**
 * The type Sauce test.
 */
public class SauceTest extends BaseTest {
    private static final Logger LOGGER = getLoggerForCurrentClass();

    private final static PageHeader pageHeader = new PageHeader();
    private final static ShoppingCartPage cartPage = new ShoppingCartPage();

    private final static String BASE_URL = getBaseUrl();
    private final static String INVENTORY_URL = getInventoryUrl();
    private static final String STANDARD_USER = getStandardUser();
    private static final String STANDARD_USER_PWD = getStandardUserPwd();

    private final Map<String, String> expectedMainMenuOptionsMap = ImmutableMap.of(
        "inventory_sidebar_link", "ALL ITEMS",
        "about_sidebar_link", "ABOUT",
        "logout_sidebar_link", "LOGOUT",
        "reset_sidebar_link", "RESET APP STATE"
    );


    /**
     * Successful login test.
     *
     * @param testInfo the test info
     */
    @Test
    @DisplayName("Regular user login test")
    @Tag("login")
    public void checkSuccessfulLogin(TestInfo testInfo) {
        loginWithCredentials(STANDARD_USER, STANDARD_USER_PWD);
        Assertions.assertEquals(getWebDriver().getCurrentUrl(), BASE_URL + INVENTORY_URL);
    }

    /**
     * Check navigation menu options.
     *
     * @param testInfo the test info
     */
    @Test
    @DisplayName("Navigation menu options test")
    @Tag("navigation")
    public void checkNavigationMenuOptions(TestInfo testInfo) {
        loginWithCredentials(STANDARD_USER, STANDARD_USER_PWD);
        pageHeader.getNavigationMenuButton().should(Condition.visible).click();

        ElementsCollection menuOptions = pageHeader.getNavigationMenuOptions();

        LOGGER.info("Checking list of links");
        Assertions.assertEquals(menuOptions.size(), expectedMainMenuOptionsMap.size());
        menuOptions.forEach(optionLink -> {
            Assertions.assertTrue(expectedMainMenuOptionsMap.containsKey(optionLink.attr("id")));
            Assertions.assertTrue(expectedMainMenuOptionsMap.containsValue(optionLink.text()));
        });
    }

    /**
     * Check null pointer.
     *
     * @param testInfo the test info
     */
    @Test
    @DisplayName("Nullpointer exception test")
    @Tag("Java 14")
    public void checkNullPointer(TestInfo testInfo) {
        loginWithCredentials(STANDARD_USER, STANDARD_USER_PWD);
        pageHeader.getCartButton().should(Condition.visible).click();
        ElementsCollection filteredList = null;

        LOGGER.info("Provoke NPE");
//        Assertions.assertThrows(NullPointerException.class, () -> {
//            filteredList.get(0);
//        });
        Assertions.assertTrue(filteredList.get(0).$(".inventory_item_price").exists());
    }

    /**
     * Assert cart item status after quantity update.
     *
     * @param initialStatus   the initial status
     * @param actualStatus    the actual status
     * @param isReopenEnabled the is reopen enabled
     */
    @Test
    @DisplayName("Switch-case test")
    @Tag("Java 14")
    public void assertCartItemStatusAfterQuantityUpdate(String initialStatus, String actualStatus,
                                                        boolean isReopenEnabled) {
        String expectedStatus = switch (initialStatus) {
            case "New", "Open", "Customer replied" -> initialStatus;
            case "Closed" -> {
                if (isReopenEnabled) {
                    yield "Open";
                } else {
                    yield initialStatus;
                }
            }
            case "Awaiting reply from customer" -> "Customer replied";
            default -> throw new IllegalArgumentException("Invalid data is provided");
        };

        System.out.printf("Actual item status is %s%n",
            (actualStatus.equals(expectedStatus)) ? "valid" : "not valid");
    }
}


