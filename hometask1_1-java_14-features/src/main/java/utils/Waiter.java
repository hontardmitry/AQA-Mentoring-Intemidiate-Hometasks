package utils;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    public static void waitForReadyState() {
        sleep(4000);
        WebDriverWait waiter = new WebDriverWait(getWebDriver(), 10000);
        waiter.until(driver -> "complete".equals(
            executeJavaScript("return document.readyState").toString()));
    }
}
