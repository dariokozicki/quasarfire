package com.quasar.fire.rebellion.controllers;

import com.quasar.fire.rebellion.exceptions.MessageException;
import com.quasar.fire.rebellion.exceptions.TrilaterationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(value = {TrilaterationException.class})
    public ResponseEntity<HttpStatus> handleTrilaterationException(TrilaterationException ex){
        logger.error("A request was met with the TrilaterationException: " + ex.getMessage());
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {MessageException.class})
    public ResponseEntity<HttpStatus> handleMessageException(MessageException ex){
        logger.error("A request was met with the MessageException: " + ex.getMessage());
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<HttpStatus> handleException(Exception ex){
        logger.error("A request was met with an unknown exception: " + ex.getMessage());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}