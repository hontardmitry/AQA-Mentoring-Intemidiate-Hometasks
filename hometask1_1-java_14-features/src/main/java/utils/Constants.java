package utils;

/**
 * The type Constants.
 */
public class Constants {
    /**
     * Instantiates a new Constants.
     */
    public Constants() {
    }

    private final static String BASE_URL = "https://www.saucedemo.com/";
    private static final String STANDARD_USER = "standard_user";
    private static final String STANDARD_USER_PWD = "secret_sauce";
    private final static String INVENTORY_URL = "inventory.html";


    /**
     * Gets base url.
     *
     * @return the base url
     */
    public static String getBaseUrl() {
        return BASE_URL;
    }

    /**
     * Gets standard user.
     *
     * @return the standard user
     */
    public static String getStandardUser() {
        return STANDARD_USER;
    }

    /**
     * Gets standard user pwd.
     *
     * @return the standard user pwd
     */
    public static String getStandardUserPwd() {
        return STANDARD_USER_PWD;
    }

    /**
     * Gets inventory url.
     *
     * @return the inventory url
     */
    public static String getInventoryUrl() {
        return INVENTORY_URL;
    }
}
