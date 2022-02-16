package ui.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class LoginPage {
    private SelenideElement userNameInput = $("#user-name");
    private SelenideElement userPasswordInput = $("#password");
    private SelenideElement loginBtn = $("#login-button");

    public SelenideElement getNameInput() {
        return userNameInput.should(Condition.visible);
    }

    public SelenideElement getPasswordInput() {
        return userPasswordInput.should(Condition.visible);
    }

    public SelenideElement getLoginButton() {
        return loginBtn.should(Condition.visible);
    }
}
