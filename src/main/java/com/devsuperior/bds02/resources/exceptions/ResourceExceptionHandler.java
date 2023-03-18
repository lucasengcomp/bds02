package com.devsuperior.bds02.resources.exceptions;

import com.devsuperior.bds02.services.exceptions.DataBaseException;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

import static com.devsuperior.bds02.resources.exceptions.Utils.DATABASE_EXCEPTION;

public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError();
        patternMessage(error, status, Utils.RESOURCE_NOT_FOUND, e.getMessage(), request);
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<StandardError> database(DataBaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError error = new StandardError();
        patternMessage(error, status, DATABASE_EXCEPTION, e.getMessage(), request);
        return ResponseEntity.status(status).body(error);
    }

    private void patternMessage(StandardError error, HttpStatus status, String databaseException, String e, HttpServletRequest request) {
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError(databaseException);
        error.setMessage(e);
        error.setPath(request.getRequestURI());
    }
}
