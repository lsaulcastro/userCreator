package com.example.usercreator.shared.exception;

import com.example.usercreator.application.baseDto.GenericErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<GenericErrorResponse> handleGenericException(GenericException ex) {
        return new ResponseEntity<>(new GenericErrorResponse(ex.getMessage()), ex.getStatus());
    }
}
