package utils;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The type Waiter.
 */
public class Waiter {
    /**
     * The constant TIME_OUT_IN_SECONDS.
     */
    public static final int TIME_OUT_IN_SECONDS = 30;
    /**
     * The constant SLEEP_IN_MILLIS.
     */
    public static final int SLEEP_IN_MILLIS = 3;

    private Waiter() {
    }

    /**
     * Wait for ready state.
     */
    public static void waitForReadyState() {
        sleep(4000);
        WebDriverWait waiter = new WebDriverWait(getWebDriver(), 60000);
        waiter.until(driver -> "complete".equals(
            executeJavaScript("return document.readyState").toString()));
    }

}
