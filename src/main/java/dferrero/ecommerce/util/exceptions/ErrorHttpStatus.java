package dferrero.ecommerce.util.exceptions;

public class ErrorHttpStatus {

    private final String code;
    private final String message;

    public ErrorHttpStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

}