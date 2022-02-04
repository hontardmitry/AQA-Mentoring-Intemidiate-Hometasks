package ui.pages;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class ShoppingCartPage {

    public SelenideElement getItemTitle(SelenideElement parent){
        return parent.$(".inventory_item_name");
    }

    public ElementsCollection getCartItemsList(){
        return $$(".cart_list .cart_item");
    }
}
