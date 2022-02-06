package ui.pages.components;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class PageHeader {
    private final static String NAVIGATION_MENU_BTN_LOCATOR = "#react-burger-menu-btn";
    private final static String NAVIGATION_MENU_CONTAINER_LOCATOR = ".bm-menu-wrap";
    private final static String NAVIGATION_MENU_OPTION_LINK_LOCATOR = "a";
    private final static String SHOPPING_CART_LINK_LOCATOR = ".shopping_cart_link";

    public SelenideElement getNavigationMenuButton() {
        return $(NAVIGATION_MENU_BTN_LOCATOR).should(Condition.visible);
    }

    public SelenideElement getNavigationMenu() {
        return $(NAVIGATION_MENU_CONTAINER_LOCATOR).should(Condition.visible);
    }

    public ElementsCollection getNavigationMenuOptions() {
        return getNavigationMenu().should(Condition.visible).$$(NAVIGATION_MENU_OPTION_LINK_LOCATOR);
    }

    public SelenideElement getCartButton() {
        return $(SHOPPING_CART_LINK_LOCATOR).should(Condition.visible);
    }
}
