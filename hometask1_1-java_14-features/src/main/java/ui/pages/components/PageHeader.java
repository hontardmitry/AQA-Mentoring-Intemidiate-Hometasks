package ui.pages.components;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class PageHeader {

    public SelenideElement getNavigationMenuButton(){
        return $("#react-burger-menu-btn");
    }

    public SelenideElement getNavigationMenu(){
        return $(".bm-menu-wrap");
    }

    public ElementsCollection getNavigationMenuOptions(){
        return getNavigationMenu().$$(".bm-item-list a");
    }

    public SelenideElement getCartButton(){
        return $(".shopping_cart_link");
    }
}
