package com.example.shopdt.advisor;


import com.example.shopdt.exception.ExceptionBody;
import com.example.shopdt.exception.HandledException;
import com.example.shopdt.filter.CachedBodyHttpServletRequest;
import com.example.shopdt.logging.ManagerGatewayLogger;
import io.micrometer.core.instrument.util.IOUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicReference;

@RestControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(
            MethodArgumentNotValidException ex, HttpServletRequest request) throws IOException {
        AtomicReference<String> message = new AtomicReference<>("");
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            message.set(fieldName + ": " + errorMessage + ";");
        });
        ExceptionBody body = ExceptionBody.of(System.currentTimeMillis(), message.toString());
        CachedBodyHttpServletRequest cachedBodyHttpServletRequest =
                new CachedBodyHttpServletRequest(request);
        logError(cachedBodyHttpServletRequest,ex);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({HandledException.class})
    public ResponseEntity<Object> handleHandledException(
            HandledException ex, HttpServletRequest request) throws IOException {
        ExceptionBody body = ExceptionBody.of(System.currentTimeMillis(), ex.getMessage());
        CachedBodyHttpServletRequest cachedBodyHttpServletRequest =
                new CachedBodyHttpServletRequest(request);
        logError(cachedBodyHttpServletRequest,ex);
        return new ResponseEntity<>(body, HttpStatus.valueOf(ex.getCode()));
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex
            , HttpServletRequest request) throws IOException {
        ExceptionBody body = ExceptionBody.of(System.currentTimeMillis(), ex.getMessage());
        CachedBodyHttpServletRequest cachedBodyHttpServletRequest =
                new CachedBodyHttpServletRequest(request);
        logError(cachedBodyHttpServletRequest,ex);
        return new ResponseEntity<>(body, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleDefaultException(Exception ex, HttpServletRequest request) throws IOException {
        ExceptionBody body = ExceptionBody.of(System.currentTimeMillis(), "Internal server error");
        CachedBodyHttpServletRequest cachedBodyHttpServletRequest =
                new CachedBodyHttpServletRequest(request);
        logError(cachedBodyHttpServletRequest,ex);
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private void logError(CachedBodyHttpServletRequest request, Exception ex) throws IOException {

        String body = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
        StringBuilder data = new StringBuilder();
        data.append("\nLOGGING ERROR-----------------------------------\n")
                .append("[PATH]: ").append(request.getRequestURI()).append("\n")
                .append("[QUERIES]: ").append(request.getQueryString()).append("\n")
                .append("[BODY]: \n"+ body).append("\n")
                .append("[HEADERS]: ").append("\n");

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            data.append("---").append(key).append(" : ").append(value).append("\n");
        }
        data.append("LOGGING ERROR-----------------------------------\n");

        ManagerGatewayLogger.error.error(data.toString(),ex);
    }
}
