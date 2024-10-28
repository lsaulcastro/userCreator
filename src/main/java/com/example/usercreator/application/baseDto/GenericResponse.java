package com.example.usercreator.application.baseDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

/**
 * @author Saul Castro
 * @project userCreator
 * @since 10/27/2024
 */
public class GenericResponse<T> {

    @JsonProperty("statusCode")
    private Integer status;

    @JsonProperty("body")
    private T body;

    public GenericResponse(HttpStatus status, T body) {
        this.status = status.value();
        this.body = body;
    }

    public GenericResponse() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
