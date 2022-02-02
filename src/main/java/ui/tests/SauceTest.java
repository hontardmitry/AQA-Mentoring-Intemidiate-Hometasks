package ui.tests;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static ui.core.BaseTest.loginWithCredentials;
import static utils.Constants.getBaseUrl;
import static utils.Constants.getInventoryUrl;
import static utils.Constants.getStandardUser;
import static utils.Constants.getStandardUserPwd;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ui.pages.ShoppingCartPage;
import ui.pages.components.PageHeader;

import java.util.Map;

/**
 * The type Sauce test.
 */
public class SauceTest {

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
     */
    @Test
    public void checkSuccessfulLogin(){
        loginWithCredentials(STANDARD_USER, STANDARD_USER_PWD);
        Assertions.assertEquals(getWebDriver().getCurrentUrl(), BASE_URL + INVENTORY_URL);
    }

    /**
     * Check navigation menu options.
     */
    @Test
    public void checkNavigationMenuOptions(){
        loginWithCredentials(STANDARD_USER, STANDARD_USER_PWD);
        pageHeader.getNavigationMenuButton().should(Condition.visible).click();

        ElementsCollection menuOptions = pageHeader.getNavigationMenuOptions();

        Assertions.assertEquals(menuOptions.size(), expectedMainMenuOptionsMap.size());
        menuOptions.forEach(optionLink -> {
            Assertions.assertTrue(expectedMainMenuOptionsMap.containsKey(optionLink.attr("id")));
            Assertions.assertTrue(expectedMainMenuOptionsMap.containsValue(optionLink.text()));
            });
    }

    /**
     * Check null pointer.
     */
    @Test
    public void checkNullPointer(){
        loginWithCredentials(STANDARD_USER, STANDARD_USER_PWD);
        pageHeader.getCartButton().should(Condition.visible).click();
        ElementsCollection filteredList = null;

        Assertions.assertTrue(filteredList.get(0).$(".inventory_item_price").exists());
    }
}
