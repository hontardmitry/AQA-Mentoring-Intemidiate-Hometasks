package ui.pages.components;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

/**
 * The type Header.
 */
public class PageHeader {

    /**
     * Get navigation menu button selenide element.
     *
     * @return the selenide element
     */
    public SelenideElement getNavigationMenuButton(){
        return $("#react-burger-menu-btn");
    }

    /**
     * Get navigation menu selenide element.
     *
     * @return the selenide element
     */
    public SelenideElement getNavigationMenu(){
        return $(".bm-menu-wrap");
    }

    /**
     * Get navigation menu options elements collection.
     *
     * @return the elements collection
     */
    public ElementsCollection getNavigationMenuOptions(){
        return getNavigationMenu().$$(".bm-item-list a");
    }

    public SelenideElement getCartButton(){
        return $(".shopping_cart_link");
    }
}
