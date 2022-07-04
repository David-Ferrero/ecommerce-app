package dferrero.ecommerce.util.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class ErrorException extends RuntimeException {

    private static final Logger log = LoggerFactory.getLogger(ErrorException.class);


    private HttpStatus httpStatus;
    private ErrorHttpStatus customHttpStatus;

    /**
     * @param httpStatus
     * @param customHttpStatus
     */
    public ErrorException(HttpStatus httpStatus, ErrorHttpStatus customHttpStatus) {
        super(customHttpStatus.getMessage());
        this.httpStatus = httpStatus;
        this.customHttpStatus = customHttpStatus;
        log.info(String.format("[Error] %s (%s)", customHttpStatus.getMessage(), httpStatus.toString()));
    }

    /**
     * @return the httpStatus
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    /**
     * @return the customHttpStatus
     */
    public ErrorHttpStatus getCustomHttpStatus() {
        return customHttpStatus;
    }

    public int getHttpStatusCode() {
        return httpStatus.value();
    }

    public String getCustomHttpStatusCode() {
        return customHttpStatus.getCode();
    }

    public String getHttpStatusError() {
        return httpStatus != null ? httpStatus.getReasonPhrase() : customHttpStatus.getMessage();
    }

    public String getCustomHttpStatusError() {
        return getMessage();
    }

}

