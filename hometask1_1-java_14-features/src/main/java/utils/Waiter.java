package utils;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    public static final int TIME_OUT_IN_SECONDS = 30;
    public static final int SLEEP_IN_MILLIS = 3;

    private Waiter() {
    }

    public static void waitForReadyState() {
        sleep(4000);
        WebDriverWait waiter = new WebDriverWait(getWebDriver(), 60000);
        waiter.until(driver -> "complete".equals(
            executeJavaScript("return document.readyState").toString()));
    }

}
