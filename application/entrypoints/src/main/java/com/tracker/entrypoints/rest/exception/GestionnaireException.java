package com.tracker.entrypoints.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GestionnaireException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NonTrouveException.class)
    public ResponseEntity<ErreurReponse> gererNonTrouverException(NonTrouveException e, WebRequest webRequest) {
        ErreurReponse erreurReponse = new ErreurReponse(LocalDateTime.now(), e.getMessage());
        return new ResponseEntity<>(erreurReponse, HttpStatus.NOT_FOUND);
    }
}
