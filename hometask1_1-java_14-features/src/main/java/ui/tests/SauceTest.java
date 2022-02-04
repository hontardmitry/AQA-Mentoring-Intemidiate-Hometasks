package ui.tests;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.Constants.getBaseUrl;
import static utils.Constants.getInventoryUrl;
import static utils.Constants.getStandardUser;
import static utils.Constants.getStandardUserPwd;
import static utils.LogUtils.getLoggerForCurrentClass;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import ui.core.BaseTest;
import ui.pages.ShoppingCartPage;
import ui.pages.components.PageHeader;

import java.util.Map;

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


    @Test
    @DisplayName("Regular user login test")
    public void checkSuccessfulLogin(TestInfo testInfo) {
        loginWithCredentials(STANDARD_USER, STANDARD_USER_PWD);
        assertEquals(BASE_URL + INVENTORY_URL, getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Navigation menu options test")
    public void checkNavigationMenuOptions(TestInfo testInfo) {
        loginWithCredentials(STANDARD_USER, STANDARD_USER_PWD);
        pageHeader.getNavigationMenuButton().should(Condition.visible).click();

        ElementsCollection menuOptions = pageHeader.getNavigationMenuOptions();

        LOGGER.info("Checking list of links");
        assertEquals(menuOptions.size(), expectedMainMenuOptionsMap.size());
        menuOptions.forEach(optionLink -> {
            assertTrue(expectedMainMenuOptionsMap.containsKey(optionLink.attr("id")));
            assertTrue(expectedMainMenuOptionsMap.containsValue(optionLink.text()));
        });
    }

    @Test
    @DisplayName("Null pointer exception test")
    public void checkNullPointer(TestInfo testInfo) {
        loginWithCredentials(STANDARD_USER, STANDARD_USER_PWD);
        pageHeader.getCartButton().should(Condition.visible).click();
        ElementsCollection filteredList = null;

        LOGGER.info("Provoke NPE");
//        Assertions.assertThrows(NullPointerException.class, () -> {
//            filteredList.get(0);
//        });
        assertTrue(filteredList.get(0).$(".inventory_item_price").exists());
    }

    @ParameterizedTest
    @DisplayName("Switch-case test")
    @CsvSource({
        "Open,Open,true",
        "Awaiting reply from customer,Customer replied,false",
        "Awaiting reply from customer,Awaiting reply from customer,false",
        "Closed,Open,true",
        "Closed,Open,false",
    })
    public void assertCartItemStatusAfterQuantityUpdate(String initialStatus, String actualStatus,
                                                        boolean isReopenEnabled) {
        String expectedStatus = switch (initialStatus) {
            case "Closed" -> {
                if (isReopenEnabled) {
                    yield "Open";
                } else {
                    yield initialStatus;
                }
            }
            case "New", "Open", "Customer replied" -> initialStatus;
            case "Awaiting reply from customer" -> "Customer replied";
            default -> throw new IllegalArgumentException("Invalid data is provided");
        };

        assertEquals(expectedStatus, actualStatus);
    }
}


