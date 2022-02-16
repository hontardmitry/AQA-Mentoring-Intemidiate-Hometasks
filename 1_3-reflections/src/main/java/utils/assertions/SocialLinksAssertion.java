package utils.assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codeborne.selenide.SelenideElement;
import ui.pages.components.PageFooter;

import java.util.InputMismatchException;
import java.util.Objects;

public class SocialLinksAssertion {
    private final static PageFooter PAGE_FOOTER = new PageFooter();

    public static void assertSocialLink(SelenideElement link) {
        String expectedLink = switch(Objects.requireNonNull(link.getAttribute("class"))){
            case "social_twitter" -> "https://twitter.com/saucelabs";
            case "social_facebook" -> "https://www.facebook.com/saucelabs";
            case "social_linkedin" -> "https://www.linkedin.com/company/sauce-labs/";
            default -> throw new InputMismatchException("Unexpected CSS class is provided");
        };
        assertEquals(expectedLink, PAGE_FOOTER.getSocialLinkValue(link));
    }
}
