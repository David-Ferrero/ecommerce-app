package dferrero.ecommerce.util.exceptions;

import lombok.Data;

import java.io.Serializable;

@Data
public class ErrorResponse implements Serializable {

    private String timestamp;
    private int status;
    private String error;
    private String code;
    private String message;
    private String path;

}