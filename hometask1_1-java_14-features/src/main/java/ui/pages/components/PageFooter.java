package ui.pages.components;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class PageFooter {
    private final static String SOCIAL_LINKS_CONTAINER_LOCATOR = ".social";
    private final static String SOCIAL_SINGLE_LINK_CONTAINER_LOCATOR = "li";
    private final static String SOCIAL_SINGLE_LINK_LOCATOR = "a";

    public ElementsCollection getSocialLinks(){
        return $(SOCIAL_LINKS_CONTAINER_LOCATOR).should(Condition.visible)
            .$$(SOCIAL_SINGLE_LINK_CONTAINER_LOCATOR);
    }

    public String getSocialLinkValue(SelenideElement parent){
        return parent.$(SOCIAL_SINGLE_LINK_LOCATOR).getAttribute("href");
    }
}
