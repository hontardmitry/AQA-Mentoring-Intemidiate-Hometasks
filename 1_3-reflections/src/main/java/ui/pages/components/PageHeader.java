package ui.pages.components;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class PageHeader {
    private SelenideElement navigationMenuBtn = $("#react-burger-menu-btn");
    private SelenideElement navigationMenuContainer = $(".bm-menu-wrap");
    private SelenideElement shoppingCartLink = $(".shopping_cart_link");
    private ElementsCollection navigationMenuOptionsLinksList;
   private String linkLocator = "a";

    public SelenideElement getNavigationMenuButton() {
        return navigationMenuBtn.should(Condition.visible);
    }

    public SelenideElement getNavigationMenu() {
        return navigationMenuContainer.should(Condition.visible);
    }

    public ElementsCollection getNavigationMenuOptionsLinksList() {
        navigationMenuOptionsLinksList = getNavigationMenu().$$(linkLocator);
        return navigationMenuOptionsLinksList;
    }

    public SelenideElement getCartButton() {
        return shoppingCartLink.should(Condition.visible);
    }
}
