package ui.pages;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

/**
 * The type Login page.
 */
public class LoginPage {

    /**
     * Get name input selenide element.
     *
     * @return the selenide element
     */
    public SelenideElement getNameInput(){
        return $("#user-name");
    }

    /**
     * Get password input selenide element.
     *
     * @return the selenide element
     */
    public SelenideElement getPasswordInput(){
        return $("#password");
    }

    /**
     * Get login button selenide element.
     *
     * @return the selenide element
     */
    public SelenideElement getLoginButton(){
        return $("#login-button");
    }
}
