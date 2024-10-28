package com.example.usercreator.application.baseDto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
public class GenericErrorResponse implements Serializable {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 11231233L;

    @JsonProperty("mensaje")
    private String message;

    public GenericErrorResponse(String message) {
        this.message = message;
    }

    public GenericErrorResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
