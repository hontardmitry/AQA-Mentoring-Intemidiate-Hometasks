package utils.enums;

public enum Constants {

    BASE_URL("https://www.saucedemo.com/"),
    STANDARD_USER("standard_user"),
    STANDARD_USER_PASSWORD("secret_sauce"),
    INVENTORY_URL("inventory.html");

    private final String constantValue;

    Constants(String constantValue) {
        this.constantValue = constantValue;
    }

    public String getValue() {
        return constantValue;
    }
}
