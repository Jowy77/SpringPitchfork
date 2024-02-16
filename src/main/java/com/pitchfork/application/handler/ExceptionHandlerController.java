package com.pitchfork.application.handler;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.pitchfork.application.handler.dto.ApiError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiError> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleException(Exception ex) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "There was an internal server error.");
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        String errorMessage = "Error reading JSON message.";

        if (ex.getCause() instanceof InvalidFormatException) {
            InvalidFormatException ife = (InvalidFormatException) ex.getCause();
            errorMessage = formatInvalidFormatException(ife);
        }

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, errorMessage);
        return ResponseEntity.badRequest().body(apiError);
    }

    private String formatInvalidFormatException(InvalidFormatException ife) {
        String fieldName = ife.getPath().stream()
                .map(JsonMappingException.Reference::getFieldName)
                .reduce((first, second) -> second)
                .orElse("Unknown");
        String invalidValue = ife.getValue().toString();
        return String.format("Format error in field '%s'. Invalid value: '%s'", fieldName, invalidValue);
    }
}