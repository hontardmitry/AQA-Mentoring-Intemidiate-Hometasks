package ui.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class LoginPage {

    public SelenideElement getNameInput() {
        return $("#user-name").should(Condition.visible);
    }

    public SelenideElement getPasswordInput() {

        return $("#password").should(Condition.visible);
    }

    public SelenideElement getLoginButton() {

        return $("#login-button").should(Condition.visible);
    }
}
