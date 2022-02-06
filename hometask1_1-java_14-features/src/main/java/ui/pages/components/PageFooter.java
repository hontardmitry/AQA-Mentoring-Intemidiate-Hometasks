package ui.pages.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

public class PageFooter {
    public ElementsCollection getSocialLinks(){
        $(".social").should(Condition.visible);
        return $$(".social li");
    }
}
