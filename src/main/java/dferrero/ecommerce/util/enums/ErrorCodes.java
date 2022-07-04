package dferrero.ecommerce.util.enums;

public enum ErrorCodes {

    INVALID_PRODUCT_ID("El identificador de producto no es correcto"),
    INVALID_BRAND_ID("El identificador de marca no es correcto"),
    INVALID_DATE_NULL("La fecha no puede ser un valor nulo");

    private final String code;

    ErrorCodes(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public static ErrorCodes valueOfCode(String code) {
        for (ErrorCodes errorCode : ErrorCodes.values()) {
            if (errorCode.getCode().equals(code))
                return errorCode;
        }

        return null;
    }

}
