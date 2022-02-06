package ui.pages.components;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class PageHeader {

    public SelenideElement getNavigationMenuButton() {
        return $("#react-burger-menu-btn").should(Condition.visible);
    }

    public SelenideElement getNavigationMenu() {

        return $(".bm-menu-wrap").should(Condition.visible);
    }

    public ElementsCollection getNavigationMenuOptions() {

        return getNavigationMenu().should(Condition.visible).$$(".bm-item-list a");
    }

    public SelenideElement getCartButton() {

        return $(".shopping_cart_link").should(Condition.visible);
    }
}
