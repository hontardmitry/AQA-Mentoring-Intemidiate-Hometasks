package ui.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class LoginPage {
    private final static String USER_NAME_INPUT_LOCATOR = "#user-name";
    private final static String USER_PASSWORD_INPUT_LOCATOR = "#password";
    private final static String LOGIN_BTN_LOCATOR = "#login-button";

    public SelenideElement getNameInput() {
        return $(USER_NAME_INPUT_LOCATOR).should(Condition.visible);
    }

    public SelenideElement getPasswordInput() {
        return $(USER_PASSWORD_INPUT_LOCATOR).should(Condition.visible);
    }

    public SelenideElement getLoginButton() {
        return $(LOGIN_BTN_LOCATOR).should(Condition.visible);
    }
}
