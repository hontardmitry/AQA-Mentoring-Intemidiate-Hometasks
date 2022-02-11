package ui.pages.components;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class PageFooter {
    private String socialLinkContainerLocator ="li";
    private String linkLocator ="a";
    private SelenideElement socialLinksListContainer = $(".social");
    private SelenideElement socialLink;
    private ElementsCollection socialLinksContainersList;

    public ElementsCollection getSocialLinksContainersList(){
        socialLinksContainersList = getSocialLinksListContainer().$$(socialLinkContainerLocator);
        return socialLinksContainersList;
    }

    public SelenideElement getSocialLinksListContainer() {
        return socialLinksListContainer.should(Condition.visible);
    }

    public String getSocialLinkValue(SelenideElement socialLinkContainer){
        socialLink = socialLinkContainer.$(linkLocator);
        return socialLink.getAttribute("href");
    }
}

