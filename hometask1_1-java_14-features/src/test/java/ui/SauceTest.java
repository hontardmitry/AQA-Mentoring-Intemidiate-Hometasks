package ui;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.enums.Constants.BASE_URL;
import static utils.enums.Constants.INVENTORY_URL;

import com.codeborne.selenide.ElementsCollection;
import com.google.common.collect.ImmutableMap;
import core.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

public class SauceTest extends BaseTest {

    private final Map<String, String> expectedMainMenuOptionsMap = ImmutableMap.of(
        "inventory_sidebar_link", "ALL ITEMS",
        "about_sidebar_link", "ABOUT",
        "logout_sidebar_link", "LOGOUT",
        "reset_sidebar_link", "RESET APP STATE"
    );

    @Test
    @DisplayName("Regular user login test")
    public void checkSuccessfulLogin() {
        loginWithStandardUser();
        assertEquals(BASE_URL.getValue() + INVENTORY_URL.getValue(), getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Navigation menu options test")
    public void checkNavigationMenuOptions() {
        loginWithStandardUser();
        pageHeader.getNavigationMenuButton().click();
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
    public void checkNullPointer() {
        loginWithStandardUser();
        pageHeader.getCartButton().click();
        ElementsCollection filteredList = null;

        LOGGER.info("Provoke NPE");
        assertTrue(filteredList.get(0).$(".inventory_item_price").exists());
    }

    @ParameterizedTest
    @DisplayName("Switch-case test")
    @CsvSource({
        "Open,Open,true",
        "Awaiting reply from customer,Customer replied,false",
        "Awaiting reply from customer,Awaiting reply from customer,false",
        "Closed,Open,true",
        "Closed,Closed,false",
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


