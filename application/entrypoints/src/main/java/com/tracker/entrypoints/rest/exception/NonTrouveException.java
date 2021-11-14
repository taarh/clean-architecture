package com.tracker.entrypoints.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NonTrouveException extends  RuntimeException{

    public NonTrouveException(String message) {
        super(message);
    }
}