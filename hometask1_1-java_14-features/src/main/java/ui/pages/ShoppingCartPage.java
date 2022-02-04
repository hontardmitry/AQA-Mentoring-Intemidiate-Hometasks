package ui.pages;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

/**
 * The type Shopping cart page.
 */
public class ShoppingCartPage {

    /**
     * Get item title selenide element.
     *
     * @param parent the parent
     * @return the selenide element
     */
    public SelenideElement getItemTitle(SelenideElement parent){
        return parent.$(".inventory_item_name");
    }

    /**
     * Get cart items list elements collection.
     *
     * @return the elements collection
     */
    public ElementsCollection getCartItemsList(){
        return $$(".cart_list .cart_item");
    }
}
