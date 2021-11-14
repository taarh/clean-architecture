package com.tracker.entrypoints.rest.exception;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ErreurReponse implements Serializable {
    private final LocalDateTime timestamp;
    private final String message;

}
