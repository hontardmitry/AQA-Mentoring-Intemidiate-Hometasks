package ui;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.enums.Constants.BASE_URL;
import static utils.enums.Constants.INVENTORY_URL;
import static utils.enums.TestTypes.UI;

import com.codeborne.selenide.ElementsCollection;
import com.google.common.collect.ImmutableMap;
import common.BaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.pages.components.PageFooter;
import utils.annotations.TestType;
import utils.assertions.SocialLinksAssertion;

import java.util.Map;

@TestType(UI)
public class SauceTest extends BaseTest {

    private static final PageFooter PAGE_FOOTER = new PageFooter();

    private final Map<String, String> expectedMainMenuOptionsMap = ImmutableMap.of(
        "inventory_sidebar_link", "ALL ITEMS",
        "about_sidebar_link", "ABOUT",
        "logout_sidebar_link", "LOGOUT",
        "reset_sidebar_link", "RESET APP STATE"
    );

    @Test
    @DisplayName("Regular user login test")
    public void checkSuccessfulLoginTest() {
        loginWithStandardUser();
        assertEquals(BASE_URL.getValue() + INVENTORY_URL.getValue(), getWebDriver().getCurrentUrl());
    }

    @Test
    @DisplayName("Navigation menu options test")
    public void checkNavigationMenuOptions() {
        loginWithStandardUser();
        PAGE_HEADER.getNavigationMenuButton().click();
        ElementsCollection menuOptionsLinksList = PAGE_HEADER.getNavigationMenuOptionsLinksList();

        LOGGER.info("Checking list of links");
        assertEquals(menuOptionsLinksList.size(), expectedMainMenuOptionsMap.size());
        menuOptionsLinksList.forEach(optionLink -> {
            assertTrue(expectedMainMenuOptionsMap.containsKey(optionLink.attr("id")));
            assertTrue(expectedMainMenuOptionsMap.containsValue(optionLink.text()));
        });
    }

    @Test
    @Disabled
    @DisplayName("Null pointer exception test")
    public void checkNullPointer() {
        loginWithStandardUser();
        PAGE_HEADER.getCartButton().click();
        ElementsCollection filteredList = null;

        LOGGER.info("Provoke NPE");
        assertTrue(filteredList.get(0).$(".inventory_item_price").exists());
    }

    @Test
    @DisplayName("Check social links test")
    public void checkSocialLinks(){
        loginWithStandardUser();
        PAGE_FOOTER.getSocialLinksContainersList().forEach(SocialLinksAssertion::assertSocialLink);
    }
}


