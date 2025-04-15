package org.skypro.skyshop.exceptions;

public class ShopError {
    private final String code; // = "404";
    private final String message;// = "Несуществующий id";

    public ShopError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
