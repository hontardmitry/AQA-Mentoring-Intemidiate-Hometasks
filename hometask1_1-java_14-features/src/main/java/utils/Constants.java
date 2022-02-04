package utils;

public class Constants {
    private final static String BASE_URL = "https://www.saucedemo.com/";
    private static final String STANDARD_USER = "standard_user";
    private static final String STANDARD_USER_PWD = "secret_sauce";
    private final static String INVENTORY_URL = "inventory.html";


    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getStandardUser() {
        return STANDARD_USER;
    }

    public static String getStandardUserPwd() {
        return STANDARD_USER_PWD;
    }

    public static String getInventoryUrl() {
        return INVENTORY_URL;
    }
}
