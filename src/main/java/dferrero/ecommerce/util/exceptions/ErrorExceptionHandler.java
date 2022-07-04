package dferrero.ecommerce.util.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import dferrero.ecommerce.util.constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestControllerAdvice
class ErrorExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ErrorExceptionHandler.class);

    @ExceptionHandler(ErrorException.class)
    public ResponseEntity<ErrorResponse> defaultErrorHandler(HttpServletRequest req, ErrorException customException) {
        Date currentDate = new Date();
        long timestamp = currentDate.getTime();
        ErrorResponse errorContent = new ErrorResponse();
        errorContent.setTimestamp((new SimpleDateFormat(Constants.ISO_8601_FORMAT).format(timestamp)));
        errorContent.setStatus(customException.getHttpStatusCode());
        errorContent.setError(customException.getHttpStatusError());
        errorContent.setCode(customException.getCustomHttpStatusCode());
        errorContent.setMessage(customException.getCustomHttpStatusError());
        errorContent.setPath(req.getRequestURI());

        log.error("Error Exception: {}", errorContent);
        return new ResponseEntity<>(errorContent, customException.getHttpStatus());

    }

}