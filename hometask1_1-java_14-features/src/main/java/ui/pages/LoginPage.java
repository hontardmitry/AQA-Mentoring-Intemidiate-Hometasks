package ui.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class LoginPage {

    public SelenideElement getNameInput(){
        return $("#user-name");
    }

    public SelenideElement getPasswordInput(){
        return $("#password");
    }

    public SelenideElement getLoginButton(){
        return $("#login-button");
    }
}
