package com.example.usercreator.shared.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
public class GenericException extends RuntimeException {
    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 1312321313751L;

    private transient final HttpStatus status;

    public GenericException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
